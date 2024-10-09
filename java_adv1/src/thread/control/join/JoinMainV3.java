package thread.control.join;

import util.ThreadUtils;

import static util.MyLogger.log;

public class JoinMainV3 {

    public static void main(String[] args) throws InterruptedException {
        log("전체 작업 시작");

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread thread1 = new Thread(sumTask1, "Thread-1");
        Thread thread2 = new Thread(sumTask2, "Thread-2");

        thread1.start();
        thread2.start();

        log("join() - main 스레드가 thread1, thread2 종료까지 대기");
        thread1.join(); // thread1 종료될 때까지 WAITING 상태
        thread2.join(); // thread1이 이미 TERMINATED라면 RUNNABLE, 아직 실행 중이라면 종료될 때까지 WAITING 상태
        log("main 스레드 대기 완료"); // main 스레드 RUNNABLE 상태로 전환
        // join의 단점은 다른 스레드가 완료될 때까지 무기한으로 기다린다는 점

        log("sumTask1.result = " + sumTask1.result);
        log("sumTask2.result = " + sumTask2.result);

        int sumAll = sumTask1.result + sumTask2.result;
        log("sumTask1 + sumTask2 = " + sumAll);
        
        log("전체 작업 종료");
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
            ThreadUtils.sleep(2000); // 수행시간이 2초 걸리는 복잡한 로직 가정
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }

    /*
        this가 생략되면 지역변수에서 먼저 찾고 없으면 this.result처럼 인식됨.
        여기서 this는 실행된 메서드의 인스턴스 참조값.
        스택 안의 메서드 프레임 안에는 인스턴스 참조값(this)가 있어서 어떤 인스턴스에서의 메서드 실행인지 알 수 있음
     */
}
