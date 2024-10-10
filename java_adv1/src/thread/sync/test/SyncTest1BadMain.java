package thread.sync.test;

public class SyncTest1BadMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start(); // Counter 클래스 내부만 변경 가능하다고 했으니 join 순서 변경 x
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("결과 : " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
