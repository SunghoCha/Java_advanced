package thread.bounded;

import util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;

public class BoundedMain {

    private static final int MAX_SIZE = 2;

    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV1(MAX_SIZE);

        // 2. 생산자, 소비자 실행 순서 선택, 반드시 하나만 선택해서 하기
        //producerFirst(queue);
        consumerFirst(queue);
    }

    private static void producerFirst(BoundedQueue queue) {
        log("====== [생성자 먼저 실행 케이스] 시작, " + queue.getClass().getSimpleName() + " ======");

        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        printAllState(queue, threads);
        startConsumer(queue, threads);
        printAllState(queue, threads);

        log("====== [생성자 먼저 실행 케이스] 종료, " + queue.getClass().getSimpleName() + " ======");
    }

    private static void consumerFirst(BoundedQueue queue) {
        log("====== [생성자 먼저 실행 케이스] 시작, " + queue.getClass().getSimpleName() + " ======");

        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllState(queue, threads);
        startProducer(queue, threads);
        printAllState(queue, threads);

        log("====== [생성자 먼저 실행 케이스] 종료, " + queue.getClass().getSimpleName() + " ======");
    }


    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("=== 생산자 시작 === ");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            ThreadUtils.sleep(100); // 스레드 넘버링 1,2,3 순서대로 실행순서 보장해서 로그보기 편하게 하기 위한 임시용도
        }
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("=== 소비자 시작 === ");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            ThreadUtils.sleep(100); // 스레드 넘버링 1,2,3 순서대로 실행순서 보장해서 로그보기 편하게 하기 위한 임시용도
        }
    }

    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("=== 현재 상태 출력 === ");
        log( "큐 데이터:  " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }
}
