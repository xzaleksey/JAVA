package net.wikijava.chapter16.readfiles;

import java.io.*;

public class FormattedMemoryInput {
    public static synchronized void main(String[] args)
            throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16\\readfiles\\MemoryInput.java").getBytes()));
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {

            testEOF();
        }

    }

    public static synchronized void testEOF() throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16\\readfiles\\MemoryInput.java")));
        while (in.available() != 0)
            System.out.print((char) in.readByte());
    }
}

