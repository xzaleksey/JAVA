package useful;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    static final Lock LOCK = new ReentrantLock();
    static final Condition CONDITION = LOCK.newCondition();
    static boolean canEnd;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> {
            LOCK.lock();
            try {
                CONDITION.signal();
            } finally {
                LOCK.unlock();
                canEnd = true;
            }
        }, 2, TimeUnit.SECONDS);

        LOCK.lock();
        while (!canEnd) {
            System.out.println(false);
            CONDITION.await();
        }
        LOCK.unlock();
        System.out.println(true);
        service.shutdown();
    }
}
