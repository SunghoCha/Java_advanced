package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queuedTasksSize = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();

            log("[poolSize= " + poolSize + ", activeCount= " + activeCount
                    + ", queuedTasksSize= " + queuedTasksSize + ", completedTaskCount= " + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }
}
