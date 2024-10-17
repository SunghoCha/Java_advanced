package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String writerString = "ABC";
        System.out.println("writerString = " + writerString);

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
        osw.write(writerString);
        osw.close();

        // 파일에서 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuilder content = new StringBuilder();
        StringBuilder content2 = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) { // reader는 문자인 char을 반환하지만 -1을 표현하기 위해 int형으로 반환함. (char) 형변환해줘야함
            content.append((char) ch);
            content2.append(ch);
        }
        isr.close();

        System.out.println("read String: " + content);
        System.out.println("read byte: " + content2);

    }
}
