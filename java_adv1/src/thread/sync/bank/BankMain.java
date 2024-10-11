package thread.sync.bank;

import util.ThreadUtils;

import static util.MyLogger.log;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        //BankAccount account = new BankAccountV1(1000);
        //BankAccount account = new BankAccountV2(1000);
        //BankAccount account = new BankAccountV3(1000);
        //BankAccount account = new BankAccountV4(1000);
        //BankAccount account = new BankAccountV5(1000);
        BankAccount account = new BankAccountV6(1000);

        Thread task1 = new Thread(new WithdrawTask(account, 800), "Task1");
        Thread task2 = new Thread(new WithdrawTask(account, 800), "Task2");

        task1.start();
        task2.start();

        ThreadUtils.sleep(1000); // 검증 완료까지 잠시 대기
        log("task1 state: " + task1.getState());
        log("task2 state: " + task2.getState());

        task1.join();
        task2.join();
        log("[최종 잔액]: " + account.getBalance());
    }
}
