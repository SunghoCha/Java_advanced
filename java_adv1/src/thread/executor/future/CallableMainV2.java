package thread.executor.future;

import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("sumbmit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = " + future);

        log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 WAITING");
        Integer result = future.get();
        log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 RUNNABLE");

        log("result value = " + result);
        log("future 완료, future = " + future);

        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");

            ThreadUtils.sleep(2000);
            int value = new Random().nextInt();
            log("create value = " + value);

            log("Callable 완료");
            return value;
        }
    }
}
