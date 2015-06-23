package net.wikijava.chapter16.writefiles;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args)
            throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16\\writefiles\\Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16\\writefiles\\Data.txt")));
        System.out.println(in.readDouble());
        // Только readUTF() нормально читает
        // строки в кодировке UTF для Java:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
