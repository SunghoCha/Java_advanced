package thread.control.interrupt;

import util.ThreadUtils;

import static util.MyLogger.log;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(500);
        log("작업 중단 지시 thread.interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경하지 않음
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("작업 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생하여 종료 실패");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
        }
    }
    
    /*
        isInterrupted()메서드는 단순히 인터럽트의 상태확인만 하기 때문에 work 스레드의 인터럽트 상태가 계속 true로 유지되는 문제 발생.
        work 스레드의 인터럽트 상태가 true인 상태에서 자원정리와 같은 다른 작업 중 sleep()같은 코드가 수행되면 의도치않게 인터럽트 예외가 발생하면서
        정상흐름을 벗어남.
        우리가 의도했던 것은 처음 while()문을 탈출하기 위해 딱 한 번만 인터럽트를 사용하는 것이지 계속해서 인터럽트 발생을 의도한 것이 아님

        ==> 인터럽트의 목적을 달성하면 인터럽트의 상태를 다시 정상으로 돌려두어야 한다.
     */
}

