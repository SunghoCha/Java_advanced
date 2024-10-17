package io.text;

import javax.lang.model.SourceVersion;
import java.io.*;

import static io.text.TextConst.*;

public class ReaderWriterMainV4 {

    public static void main(String[] args) throws IOException {

        // 입력 데이터 문자열
        String writerString = "AB C\n가나다";
        System.out.println(" === Writer String ===");
        System.out.println(writerString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writerString);
        bw.close();

        // 파일에서 읽기
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) { // 반환 타입이 null이라 EOF을 -1로 표현 못함. 대신 null 체크
            content.append(line).append("\n");
        }
        fr.close();

        // 출력
        System.out.println(" === Read String ===");
        System.out.println(content);

    }
}
