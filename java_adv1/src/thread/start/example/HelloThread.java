package thread.start.example;


public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()"); // 실행 중인 스레드의 이름 조회
    }

    /*
        Thread를 확장하거나 Runnable 인터페이스를 구현하는 2 가지 방법이 있음.
        Thread 클래스를 상속하고 스레드가 실행할 코드를 run() 메서드에 재정의한다.
        Thread.currentThread()를 호출하면 해당 코드를 실행하는 스레드 객체 조회 가능.


     */
}
