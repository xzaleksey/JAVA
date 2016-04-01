package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

public class TestFutureTasksCancel {
    public static HashMap<Integer, Future<Boolean>> integerMyCallableHashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            integerMyCallableHashMap.put(i, executorService.submit(new MyCallable(i)));
        }
        Iterator<Map.Entry<Integer, Future<Boolean>>> iterator = integerMyCallableHashMap.entrySet().iterator();
        TimeUnit.SECONDS.sleep(3);
        while (iterator.hasNext()) {
            final Future<Boolean> value = iterator.next().getValue();
            System.out.println("try" + value);
            value.cancel(true);
        }
        executorService.shutdown();
    }

    static class MyCallable implements Callable<Boolean> {
        final int id;

        public MyCallable(int id) {
            this.id = id;
        }

        @Override
        public Boolean call() throws Exception {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(id + Thread.currentThread().toString());
            }
            return null;
        }
    }
}
