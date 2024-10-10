package thread.sync.test;

import static util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                counter.count();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

    }

    static class Counter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }
    }
}
