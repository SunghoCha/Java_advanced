package io.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamEtcMain {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("hello java!");
        printStream.println(100);
        printStream.println(true);
        printStream.println();
        printStream.printf("hello %s", "spring");
        printStream.close();
    }
}
