package start.thread;

public class HelloThreadMain {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": before start()");
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": after start()");

        System.out.println(thread.getName() + ": main() end");

        /*
            start() 메서드를 통해 스레드를 실행해야만 새로운 스레드에서 run() 메서드의 코드가 실행된다는 점이 중요한 포인트.
            run()메서드의 실행 결과인 Thread-0: run()는 start()로 실행된 이후의 main 스레드 흐름 중간 어느시점에 나올지 알 수 없음
            (실행 결과는 스레드의 실행 순서에 따라 약간 다를 수 있다.)

            HelloThread 스레드 객체를 생성하고 start() 메서드를 호출
            start() 메서드는 스레드를 실행하는 특별한 메서드이다.
            start()를 호출하면 HelloThread 스레드가 run() 메서드를 실행한다.

            반드시 run() 메서드가 아닌 start()를 호출해야함. 그래야 별도의 스레드에서 run() 코드가 실행됨
            (start() 메서드를 호출하면 새로운 스레드가 생성되고 해당 스레드는 run() 메서드를 실행한다.
            그러나 start()를 호출하지 않고 run()을 직접 호출하면 새로운 스레드가 생성되지 않고 현재 스레드에서 실행된다.)
         */

        /*
            실행 결과를 보면 main() 메서드는 main이라는 이름의 스레드가 실행하는 것을 확인할 수 있음
            프로세스가 작동하려면 스레드가 최소한 하나는 있어야 코드를 실행할 수 있다.
            자바는 실행 시점에 main이라는 이름의 스레드를 만들고 프로그램의 시작점인 main()메서드를 실행한다.

            HelloThread 스레드 객체를 생성한 다음 start() 메서드를 호출하면 자바는 스레드를 위한 "별도의 스택 공간"을 할당한다.
            스레드 객체를 생성하고 반드시 start()를 호출해야 스택 공간을 할당받고 스레드가 작동한다. 그전까지는 단순한 객체 덩어리에 불과.

            스레드에 이름을 주지 않으면 자바는 스레드에 Thread-0,1,2.. 같은 임의의 이름을 부여한다.
            start()를 호출해 새로운 Thread-0 스레드가 사용할 전용 스택 공간이 생기며, run() 메서드의 스택 프레임을 스택에 올리면서 run()메서드를 시작한다.
         */

        /*
            여기서 핵심은 main 스레드가 run() 메서드를 실행하는게 아니라 Thread-0 스레드가 run() 메서드를 실행한다는 점이다.
            main 스레드는 단지 start() 메서드를 통해 Thread-0 스레드에게 실행을 지시만 하고 바로 start() 메서드를 빠져나온다.

            이제 main 스레드와 Thread-0 스레드는 동시에 실행된다.
            동시에 실행되기 때문에 스레드 간 실행 순서는 보장되지 않는다.
            
            CPU 코어가 여러개여서 물리적으로 동시에 실행될 수도 있고, 하나의 CPU 코어에서 시간을 나누어 실행될 수도 있다.
            그리고 한 스레드가 얼마나 오랜기간 실행되는지도 보장하지 않는다. 한 스레드가 먼저 다 수행된 다음에 다른 스레드가 수행될 수도 있으며
            둘이 완전히 번갈아 가면서 수행되는 경우도 있다.
            
            스레드는 순서와 실행 기간을 보장하지 않는다. -> 멀티 스레드
         */
    }
}
