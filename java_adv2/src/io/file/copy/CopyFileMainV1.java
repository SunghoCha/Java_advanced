package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileMainV1 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

        // 파일(copy.dat) -> 자바(byte) -> 파일(copy_new.dat)
        byte[] readAllBytes = fis.readAllBytes(); // copy.dat 파일의 데이터를 자바 프로세스가 사용하는 메모리에 불러옴
        fos.write(readAllBytes); // 메모리에 있는 데이터를 copy_new.dat 파일에 전달

        fis.close();
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
