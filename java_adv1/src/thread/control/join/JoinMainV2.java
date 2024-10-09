package thread.control.join;

import util.ThreadUtils;

import static util.MyLogger.log;

public class JoinMainV2 {

    public static void main(String[] args) {
        log("전체 작업 시작");

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread thread1 = new Thread(sumTask1, "Thread-1");
        Thread thread2 = new Thread(sumTask2, "Thread-2");

        thread1.start();
        thread2.start();

        log("main 스레드 sleep() start"); // 이렇게 시간 설정으로 기다리는건 정확한 타이밍 맞추기 어려움
        ThreadUtils.sleep(3000);
        log("main 스레드 sleep() end");

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
