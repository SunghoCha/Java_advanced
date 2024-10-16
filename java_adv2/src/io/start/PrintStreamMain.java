package io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;

        byte[] bytes = "Hello\n".getBytes(StandardCharsets.UTF_8);
        printStream.write(bytes);
        printStream.println(Arrays.toString(bytes));
        printStream.println("Print");
    }
}
