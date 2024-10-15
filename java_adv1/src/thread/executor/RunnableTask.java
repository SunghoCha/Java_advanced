package thread.executor;

import util.ThreadUtils;

import static util.MyLogger.log;

public class RunnableTask implements Runnable {
    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        ThreadUtils.sleep(sleepMs); // 작업에 걸리는 시간이라고 가정
        log(name + " 완료");
    }
}
