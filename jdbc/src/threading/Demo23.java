package threading;
//标准库的阻塞队列
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>(100);
        //带阻塞功能的入队列
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        //带阻塞功能的出队列
        Integer ret=blockingQueue.take();
        System.out.println(ret);
        ret=blockingQueue.take();
        System.out.println(ret);
        ret=blockingQueue.take();
        System.out.println(ret);
//加了下面的就会阻塞
        ret=blockingQueue.take();
        System.out.println(ret);
    }
}
