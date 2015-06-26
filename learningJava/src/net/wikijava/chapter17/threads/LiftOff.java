package net.wikijava.chapter17.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10; // Значение по умолчанию

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
//        execute(exec);
//        exec = Executors.newFixedThreadPool(5);
//        execute(exec);
        exec =
                Executors.newSingleThreadExecutor();
        execute(exec);
    }

    public static void execute(ExecutorService exec) {
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

}
