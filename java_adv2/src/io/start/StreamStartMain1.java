package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        // 디렉토리는 아니지만 파일은 없으면 생성해줌. 파일 내용을 다 지우고 새롭게 입력해줌()
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        //FileOutputStream fos = new FileOutputStream("temp/hello.dat", true); // append 속성을 true=로 하면 기존의 문서 내용 끝에 추가함
        fos.write(65); // write()는 byte 단위로 값을 출력함
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("/temp/hello.dat");
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        fis.close();
    }
}
