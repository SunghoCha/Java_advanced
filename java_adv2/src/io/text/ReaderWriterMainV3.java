package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        // 입력 데이터
        String writeString = "ABC";

        // 파일에 쓰기
        FileWriter writer = new FileWriter(FILE_NAME, UTF_8);
        writer.write(writeString);
        writer.close();

        // 파일에서 읽기
        FileReader reader = new FileReader(FILE_NAME, UTF_8);
        int ch;
        StringBuilder content = new StringBuilder();
        while((ch = reader.read()) != -1) {
            content.append((char) ch);
        }
        reader.close();

        // 출력
        System.out.println("content = " + content);
    }
}
