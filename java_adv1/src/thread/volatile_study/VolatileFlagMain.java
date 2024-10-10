package thread.volatile_study;

import util.ThreadUtils;

import static util.MyLogger.log;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        ThreadUtils.sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true; // 메모리 가시성 문제로 volatile을 설정해줘야함. 캐시메모리에 있는 변경된 값이 언제 하드웨어의 메인 메모리에 반영될 지 알 수 없음 (컨텍스트 스위칭 때 반영되긴 하지만 불확실성 증가)

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false로 바뀌면 탈출
            }
            log("task 종료");
        }
    }
}
