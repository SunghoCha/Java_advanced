package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread thread1 = getThread(1000, "A");
        thread1.setName("Thread-A");
        thread1.start();

        Thread thread2 = getThread(500, "B");
        thread2.setName("Thread-B");
        thread2.start();
    }

    private static Thread getThread(int time, String s) {
        return new Thread(() -> {
            while (true) {
                log("value: " + s);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
