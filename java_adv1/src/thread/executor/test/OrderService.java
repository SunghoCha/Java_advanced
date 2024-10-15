package thread.executor.test;

import java.util.concurrent.ExecutionException;

public interface OrderService {

    void order(String orderNo) throws ExecutionException, InterruptedException;
}
