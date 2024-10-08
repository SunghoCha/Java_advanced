package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

    // 현재 시간을 원하는 포맷으로 출력하기 위해 DateTimeFormatter 사용
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) { // 문자나 숫자 타입 다 받을 수 있도록 Object 로 받음. toString 으로 출력됨
        String time = LocalDateTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
    // %s는 문자열을 뜻하는데 Object 타입넘기면 toString()을 사용해서 문자열로 변환 후 출력함
    // %9s는 문자를 출력할 때 9칸을 확보한다는 뜻. 데이터 길이 상관없이 일정한 크기 유지해서 가독성 높이기 위함
    
    
}
