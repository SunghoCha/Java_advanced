package util;

import static util.MyLogger.log;

public abstract class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    /*
        체크 예외에만 해당
        부모에 해당하는 인터페이스인 Runnable에서 예외를 던지도록 구현하지 않았으므로 자식에서도 불가능
        부모가 던지는 예외 범위보다 작은 범위에서만 자식이 예외 던지는것이 가능함
        그렇지 않으면 try/catch에서 자식이 더 큰 범위의 예외를 던지는것을 catch하지 못할 수 있음
     */
}
