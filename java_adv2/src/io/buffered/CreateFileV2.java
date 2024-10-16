package io.buffered;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bufferIndex = 0;
        for (int i = 0; i < FILE_SIZE; i++) {
            // 버퍼에 쌓다가 적정 용량되면(버퍼가 꽉차면?) write
            buffer[bufferIndex++] = 1;
            if (bufferIndex == BUFFER_SIZE) {
                fos.write(buffer);
                bufferIndex = 0;
            }
        }
        // buffer 남은 용량
        if (bufferIndex > 0) {
            fos.write(buffer, 0, bufferIndex);
        }
        fos.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
