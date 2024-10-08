package thread.start.manyThread;

import thread.start.example.HelloRunnable;

import static util.MyLogger.log;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }

    // 특정 클래스 안에서만 사용되는 경우 정적 중첩 클래스 사용
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }
    }
}
