package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV3 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "Printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린트할 문서를 입력하세요. 종료 버튼 (q)");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                thread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        Queue<String> jobQueue = new ConcurrentLinkedQueue<String>(); // 동시성 컬렉션

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                try {
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(2000); // 이 때 인터럽트가 발생하면 InterruptedException이 발생하고 인터럽트 플래그가 자동으로 false로 초기화됨
                    log("출력 완료: " + job);
                    log("try 인터럽트 상태: " + Thread.currentThread().isInterrupted());
                } catch (InterruptedException e) {
                    log("catch 인터럽트 상태: " + Thread.currentThread().isInterrupted());
                    log("인터럽트 예외 발생");
                    break;
                    //Thread.currentThread().interrupt(); // 인터럽트 플래그 다시 설정(이렇게 하면 스레드의 인터럽트 상태 초기화안되는 나쁜 코드인듯)
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
