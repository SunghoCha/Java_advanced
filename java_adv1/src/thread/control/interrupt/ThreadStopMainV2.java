package thread.control.interrupt;

import util.ThreadUtils;

import static util.MyLogger.log;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(4000);
        log("작업 중단 지시 thread.interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("작업중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("thread state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}

/*
   thread.interrupt()를 호출하면 인터럽트 플래그가 설정됨.
   InterruptedException을 발생시킬 수 있는 메서드(sleep(), wait(), join())등을 호출하거나 대기중인 상태에서 thread.interrupt()를 호출하면
   즉시 예외를 발생시키고 interrupt flag가 다시 false로 변경되고 대기 상태에서 깨어나 RUNNABLE 상태가 됨
   이 때 InterruptedException을 catch로 잡아서 정상 흐름으로 변경하면 됨(스레드가 RUNNABLE 상태여야 catch의 예외 코드도 실행될 수 있음)

   **
   인터럽트가 적용되고 인터럽트 예외가 발생하면 해당 스레드는 실행 가능 상태가 되고 인터럽트 발생 상태도 정상으로 돌아온다.
   인터럽트를 사용하면 대기중인 스레드를 바로 깨워서 실행 가능한 상태로 바꿀 수 있다.
 */
