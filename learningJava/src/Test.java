import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Алексей Валякин
 * @version 1.0
 */


public class Test {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        int j = 0;
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10000000; i++) {
            lock.lock();
            try {
                j++;
            } finally {
                lock.unlock();
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println((float) (timeEnd - timeStart) / 1000);//Выведет в милисекундах если чо.

    }
}