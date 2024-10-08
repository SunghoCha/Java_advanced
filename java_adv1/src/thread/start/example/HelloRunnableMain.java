package thread.start.example;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() thread.start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable); // 작업과 스레드를 분리
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");

        /*
            Thread 를 상속해서 스레드를 구현한것과 실행 결과는 같다.
            차이가 있다면 스레드와 해당 스레드가 실행하는 작업이 서로 분리되어 있다는 것이다.
            스레드 객체를 생성할 때, 실행할 작업을 생성자로 전달하면 된다.
         */

        /*
            Thread 상속 vs Runnable 구현
            스레드를 사용할 때는 Thread 를 상속하는 방법보다 Runnable 인터페이스를 구현하는 방식을 사용하자.

            < Thread 클래스 상속 방식 >
            장점
            - 간단한 구현: Thread 클래스를 상속받아 run() 메서드만 재정의하면 됨
            단점
            - 상속의 제한: 자바는 단일 상속만 허용하므로 이미 다른 클래스를 상속받고 있는 경우 Thread 클래스 상속 불가
            - 유연성 부족: 인터페이스를 사용하는 방법에 비해 유연성 떨어짐(객체와 작업의 강결합으로 인해 다른 스레드 관리 메커니즘에서 사용 어려울 수 있음)
            
            < Runnable 인터페이스 구현 방식 >
            장점
            - 상속의 자유로움: Runnable 인터페이스 방식은 다른 클래스를 상속받아도 문제없이 구현 가능
            - 코드의 분리: 스레드와 실행할 작업을 분리하여 코드의 가독성 높임
            - 여러 스레드가 동일한 Runnable 객체를 공유할 수 있어 자원 관리에 효율적
            단점
            - Runnable 객체를 생성하고 이를 Thread 에 전달하는 과정이 추가되어 코드가 약간 복잡해질 수 있음
         */
    }
}
