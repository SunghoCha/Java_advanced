package thread.start.example;

public class HelloRunnable implements Runnable{

    // 실무에서는 Runnable 인터페이스를 구현하는 방법으로 스레드를 생성함
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");

    }
}
