package thread.control.printer;

import util.ThreadUtils;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "Printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린트할 문서를 입력하세요. 종료 버튼 (q)");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<String>(); // 동시성 컬렉션

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                ThreadUtils.sleep(2000); // 출력에 걸리는 시간 의미
                log("출력 완료: " + job);
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
    /*
        이 방식은 중료(q)를 입력했을 때 바로 반응하지 않는 문제점이 있음
        왜냐하면 printer 스레드가 반복문을 빠져나오려면 while 조건문을 체크해야 하는데, printer 스레드가 sleep(2000)을 통해 대기상태에 빠져서 작동하지 않기 때문.
        최악의 경우 q 입력 후 3초 이후에 프론트가 종료됨
        
        ==> 인터럽트를 통해 반응성이 느린 문제를 해결할 수 있음
     */
}
