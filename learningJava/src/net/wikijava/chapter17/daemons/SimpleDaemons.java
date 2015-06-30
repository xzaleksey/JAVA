package net.wikijava.chapter17.daemons;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class SimpleDaemons implements Runnable {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Необходимо вызвать перед start()
            daemon.start();
        }
        print("All daemons started");
        // TimeUnit.MILLISECONDS.sleep(175);
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                FileChannel fc =
                        new FileOutputStream("data2.txt").getChannel();
                fc.write(ByteBuffer.wrap((Thread.currentThread() + " " + this).getBytes()));
                fc.close();
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
