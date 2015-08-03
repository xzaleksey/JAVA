import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface A {
    void output(int x);
}

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });

    }


}