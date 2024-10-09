package thread.control.interrupt;

import util.ThreadUtils;

import static util.MyLogger.log;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(4000);
        log("작업 중단 지시 runFlag = false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true; // volatile는 여러 스레드에서 공유하는 값에 사용하는 키워드

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                ThreadUtils.sleep(3000);
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}

/*
    실행 로그
    =================================
    12:44:01.542 [     work] 작업 중
    12:44:04.558 [     work] 작업 중
    12:44:05.540 [     main] 작업 중단 지시 runFlag = false
    12:44:07.561 [     work] 자원 정리
    12:44:07.561 [     work] 작업 종료
    =================================
    main 스레드가 runFlag = false를 통해 작업 중단을 지시해도, work 스레드가 즉각 반응하지 않음 (약 2초 정도 이후에 자원 정리함)
    main 스레드가 runFlag = false로 변경해도 work 스레드는 sleep(3000)로 인해 3초간 잠들어 있다가 나중에서야 runFlag를 확인하고 작업 중단함

    ==> sleep()처럼 스레드가 대기하는 상태에서 스레드를 깨우고 작업도 빨리 종료할 수 있는 방법 필요


 */
