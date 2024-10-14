package thread.cas.increment;

import thread.cas.increment.IncrementInteger.*;
import util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 10000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {

        Runnable runnable = () -> {
            ThreadUtils.sleep(100); // 다른 스레드와 동시 실행을 위해 넣어줌. 안 넣으면 충돌안될 가능성 높아짐
            incrementInteger.increment();
        };

        List<Thread> threads = new ArrayList<>();

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        long endMs = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println("[" + incrementInteger.getClass().getSimpleName() + "]" + " result: " + result + ", " + (endMs - startMs) + "ms");
    }
}
