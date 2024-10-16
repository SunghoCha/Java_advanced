package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {

    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 3};

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(input);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        byte[] readAllBytes = bais.readAllBytes();
        System.out.println("readAllBytes = " + Arrays.toString(readAllBytes));
    }
}
