package net.wikijava.chapter17.atomic;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumber() {
        return serialNumber++; // Операция не является потоково-безопасной
    }
}