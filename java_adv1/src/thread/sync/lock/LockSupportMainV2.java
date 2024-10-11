package thread.sync.lock;

import util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTask(), "Thread-1");
        thread.start();

        ThreadUtils.sleep(100); // 잠시 대기해서 thread가 park 상태에 빠지도록 기다림
        log("Thread-1 state: " + thread.getState());
    }

    static class ParkTask implements Runnable {

        @Override
        public void run() {
            log("park 시작, 2초 대기");
            LockSupport.parkNanos(2000_000000); // 1ms = 10^6 ns
            log("park 시작 후 2초 경과. state 변경됨: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
