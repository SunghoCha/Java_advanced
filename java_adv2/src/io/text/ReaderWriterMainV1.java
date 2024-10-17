package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        
        // 문자 -> byte (UTF-8 인코딩)
        String writerString = "ABC";
        byte[] writerBytes = writerString.getBytes(UTF_8);
        System.out.println("writerString = " + writerString);
        System.out.println("writerBytes = " + Arrays.toString(writerBytes));

        // 파일에 쓰기 (byte)
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writerBytes);
        fos.close();

        // 파일에서 읽기 (byte)
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fis.readAllBytes();
        fis.close();

        // byte -> String (UTF-8 인코딩)
        String readString = new String(readAllBytes, UTF_8);
        System.out.println("readBytes = " + Arrays.toString(writerBytes));
        System.out.println("readString = " + readString);
    }
}
