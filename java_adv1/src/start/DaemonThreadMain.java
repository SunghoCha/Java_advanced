package start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaeMonThread daeMonThread = new DaeMonThread();
        daeMonThread.setDaemon(true); // 데몬 스레드 default 값은 false 인데 true 로 설정하면 Daemon Thread 가 됨
        daeMonThread.start(); // 데몬 스레드 여부는 start() 실행 전에 결정해야 한다. 이후에는 변경되지 않음

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaeMonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            // Thread.sleep()은 throw e가 안되서 try/catch 로 잡아줘야함 (check 예외로 설계된 이유는 추후에 설명)
            try {
                Thread.sleep(3000); // 3초간 실행되는 스레드라고 가정한 예시
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
    
    /*
        daemon thread 설정을 false 로 했을 때의 로그
        =======================================
        main: main() start
        main: main() end
        Thread-0: run() start
        Thread-0: run() end
        
        Process finished with exit code 0
        =======================================
        Process finished with exit code 0를 보면 전체 user thread가 종료되고 JVM이 종료됨

        반면에    
        daemon thread 설정을 true 로 했을 때의 로그
        =======================================
        main: main() start
        main: main() end
        Thread-0: run() start
        
        Process finished with exit code 0
        =======================================
        Thread-0: run() end가 호출되지 않고 JVM 종료됨( Process finished with exit code 0)
     */
}
