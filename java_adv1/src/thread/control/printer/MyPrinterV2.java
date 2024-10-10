package thread.control.printer;

import util.ThreadUtils;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV2 {

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
                thread.interrupt(); // 인터럽트 코드 추가 -> while문 조건 확인 전에 sleep()에서 감지가능할 듯
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
                try {
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(2000);
                    log("출력 완료: " + job);
                } catch (InterruptedException e) {
                    log("인터럽트 예외 발생");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
    /*
        interrupt()로 sleep() 상태에서 빠져나옴
        work = false : while문을 체크하는 곳에서 빠져나옴
     */

}
