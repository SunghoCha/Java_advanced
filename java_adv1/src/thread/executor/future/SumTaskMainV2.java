package thread.executor.future;

import util.ThreadUtils;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class SumTaskMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = es.submit(sumTask1);
        Future<Integer> future2 = es.submit(sumTask2);


        log("join() - main 스레드가 thread1, thread2 종료까지 대기");
        Integer sum1 = future1.get();
        Integer sum2 = future2.get();
        log("main 스레드 대기 완료");

        log("sumTask1.result = " + sum1);
        log("sumTask2.result = " + sum2);

        int sumResult = sum1 + sum2;
        log("sumTask1 + sumTask2 = " + sumResult);
        log("End");

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");
            ThreadUtils.sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            log("작업 완료 result = " + sum);
            return sum;
        }
    }
}
