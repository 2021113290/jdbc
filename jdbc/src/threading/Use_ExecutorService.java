package threading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Use_ExecutorService {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newCachedThreadPool();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }

}
