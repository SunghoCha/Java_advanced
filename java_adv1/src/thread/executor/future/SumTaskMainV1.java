package thread.executor.future;

import util.ThreadUtils;

import java.util.concurrent.Callable;

import static util.MyLogger.log;

public class SumTaskMainV1 {

    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "Thread-1");
        Thread thread2 = new Thread(sumTask2, "Thread-2");

        thread1.start();
        thread2.start();

        log("join() - main 스레드가 thread1, thread2 종료까지 대기");
        thread1.join();
        thread1.join();
        log("main 스레드 대기 완료");

        log("sumTask1.result = " + sumTask1.result);
        log("sumTask2.result = " + sumTask2.result);

        int sumResult = sumTask1.result + sumTask2.result;
        log("sumTask1 + sumTask2 = " + sumResult);
        log("End");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            ThreadUtils.sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("작업 완료 result = " + result);
        }
    }
}
