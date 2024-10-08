package thread.start.manyThread;

import thread.start.example.HelloRunnable;

import static util.MyLogger.log;

public class ManyThreadMainV1 {

    public static void main(String[] args) {
        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

        log("main() end");

        /*
            스레드 3개를 생성할 때 모두 같은 HelloRunnable 인스턴스(x001)를 스레드의 실행 작업으로 전달했다.
            Thread-0, Thread-1, Thread-2 는 모두 HelloRunnable 인스턴스에 있는 run() 메서드를 실행한다.
         */

    }
}
