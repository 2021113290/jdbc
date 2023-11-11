package threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Use_ThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(100),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 11; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
