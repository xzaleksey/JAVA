import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        //Программа работает работает
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> stringFuture = executorService.submit(new TaskWithResult(1));
        Future<String> stringFuture2 = executorService.submit(new TaskWithResult(2));
        try {
            System.out.println(stringFuture.get() + " task 1");
            System.out.println(stringFuture2.get() + " task2");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println((float) (timeEnd - timeStart) / 1000);//Выведет в милисекундах если чо.

    }

    static class TaskWithResult implements Callable<String> {
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        @Override
        public String call() {
            System.out.println("task" + id);
            int j = id == 1 ? 2000 : 1000;
            for (int i = 0; i < j; i++) {
                System.out.println("task" + id + " " + (i));
            }
            return "success";
        }
    }

}