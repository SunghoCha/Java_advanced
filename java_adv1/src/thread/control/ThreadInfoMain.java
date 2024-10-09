package thread.control;

import thread.start.example.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        // main 스레드
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread); // Thread 클래스의 toString() 메서드는 스레드ID, 스레드이름, 우선순위, 스레드 그룹을 포함하는 문자열을 반환 (Thread[#22,myThread,5,main])
        log("myThread.threadId() = " + myThread.threadId()); // 스레드의 고유 식별자를 반환. ID는 JVM내에서 각 스레드에 대해 유잃함. 스레드 생성시 할당. 직접 지정 불가
        log("myThread.getName() = " + myThread.getName()); // 스레드의 이름은 중복 가능
        log("myThread.getPriority() = " + myThread.getPriority()); // 우선순위 1(가장 낮음) ~ 10(가장 높음) 사이 설정. 실행순서는 JVM구현과 운영체제에 따라 달라질 수 있음
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());

        /*
            스레드 그룹은 자주 사용하지는 않음(참고용)
            기본적으로 모든 스레드는 부모 스레드와 동일한 스레드 그룹에 속함
            그룹화하여 특정 작업(일괄 종료, 우선순위 설정 등)을 수행할 수 있음(할 수 있는 기능이 그렇게 많지는 않음)
            새로운 스레드를 생성하는 스레드를 의미. 메인 스레드를 제외한 다른 스레드들은 기본적으로 다른 스레드에 의해서 생성됨
            이러한 생성 관계에서 새로 생성된 스레드는 생성한 스레드를 부모로 간주한다.

         */
    }
}
