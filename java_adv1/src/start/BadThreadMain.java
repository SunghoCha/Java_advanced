package start;

public class BadThreadMain {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": before start()");
        helloThread.run(); // run() 직접 실행
        System.out.println(Thread.currentThread().getName() + ": after start()");

        System.out.println(thread.getName() + ": main() end");


        /*
            helloThread.start() 했을 때의 로그
            ================================
            main: main() start
            main: before start()
            main: after start()
            main: main() end
            Thread-0: run()
            ================================

            helloThread.run() 했을 때의 로그
            ================================
            main: main() start
            main: before start()
            main: run()
            main: after start()
            main: main() end
            ================================

            Thread-0: run()가 아닌 main: run() 로그가 찍힘

            별도의 스레드가 run()을 실행하는 것이 아니라 main 스레드가 run() 메서드를 호출하는 것을 확인할 수 있음
            자바를 처음 실행하면 main 스레드가 main() 메서드를 호출하면서 시작한다.
            main 스레드는 HelloThread 인스턴스에 있는 run() 이라는 메서드를 호출한다.
            main 스레드가 run() 메서드를 실행했기 때문에 main 스레드가 사용하는 스택 위에 run() 스택 프레임이 올라간다.
            결과적으로 main 스레드에서 모든 것을 처리하게 된다.

            스레드의 start() 메서드는 스레드에 스택 공간을 할당하면서 스레드를 시작하는 아주 특별한 메서드이다.
            그리고 해당 스레드에서 run() 메서드를 실행한다.
            따라서 main 스레드가 아닌 별도의 스레드에 재정의한 run() 메서드를 실행하려면
            "반드시 start() 메서드를 호출해야 한다."
         */

    }
}
