package net.wikijava.chapter17.daemons;

//: concurrency/Daemons.java
// Потоки, порождаемые демонами, также являются демонами
// Daemon threads spawn other daemon threads.

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.printnb;

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++)
            printnb("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}

public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        // Даем потокам-демонам завершить процесс запуска:
        TimeUnit.SECONDS.sleep(1);
    }
}
