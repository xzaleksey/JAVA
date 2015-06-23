package net.wikijava.chapter16.readfiles;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16\\readfiles\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}
