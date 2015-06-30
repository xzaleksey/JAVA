package net.wikijava.chapter17.concurrency;

//: concurrency/EvenChecker.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private final int id;
    private IntGenerator generator;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    // Тестирование произвольного типа IntGenerator:
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    // Значение по умолчанию для count:
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

    public static void main(String[] args) {
        test(new IntGenerator() {
            int i = 0;

            @Override
            public int next() {
                return i++;
            }
        });
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Отмена всех EvenChecker
            }
        }
    }
}
