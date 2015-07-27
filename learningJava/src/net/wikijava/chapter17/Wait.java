package net.wikijava.chapter17;

import java.util.ArrayList;
import java.util.List;

public class Wait {
    public static void main(String[] args) throws InterruptedException {
        FillListTask task = new FillListTask(7);
        int i = 0;
        new Thread(task).start();
        synchronized (task) {
            while (!task.isFinished()) {
                task.wait();
            }
        }
        System.out.println(task.getStrings());
    }
}

class FillListTask implements Runnable {
    private final int size;
    private List<String> strings;

    public FillListTask(int size) {
        this.size = size;
    }

    public synchronized boolean isFinished() {
        return null != strings;
    }

    public List<String> getStrings() {
        return strings;
    }

    @Override
    public void run() {
        List<String> strs = new ArrayList<>(size);
        try {
            for (int i = 0; i < size; i++) {
                Thread.sleep(2000);
                strs.add("element " + String.valueOf(i));
            }
            synchronized (this) {
                strings = strs;
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}