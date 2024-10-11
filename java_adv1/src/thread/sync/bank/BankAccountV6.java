package thread.sync.bank;

import util.ThreadUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BankAccountV6 implements BankAccount {

    //    volatile private int balance;
    private int balance;
    private final Lock lock = new ReentrantLock();


    public BankAccountV6(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("[거래 시작]: " + getClass().getSimpleName());

        try {
            if (!lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);

            ThreadUtils.sleep(1000); // 출금에 걸리는 시간으로 가정함
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        } finally {
            lock.unlock(); // ReentrantLock 이용해서 lock 해제
        }
        log("[거래 종료]");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock(); // ReentrantLock 이용해서 lock 걸기
        try {
            return balance;
        } finally {
            lock.unlock(); // ReentrantLock 이용해서 lock 해제
        }
    }
}
