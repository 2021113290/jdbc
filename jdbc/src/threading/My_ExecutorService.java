package threading;

import java.util.concurrent.LinkedBlockingQueue;
class myPoll{
    //private int maxWorkCounter=10;//线程池的最大线程数，当线程数超过这个最大值就不再新增线程
    private LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();//阻塞队列组织所有的任务，使用Runnable描述一个任务
    public void submit(Runnable command) throws InterruptedException {
        queue.put(command);
    }
    public myPoll(int m){
        //在构造方法中创建m个线程，负责完成工作
        for (int i = 0; i < m; i++) {
            Thread t=new Thread(()->{
                while(true){
                    try {
                        Runnable runnable=queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}
public class My_ExecutorService {
    public static void main(String[] args) throws InterruptedException {
        myPoll poll=new myPoll(10);
        for (int i = 0; i < 1000; i++) {
            int id=i;
            poll.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println("执行当前任务："+id+";当前线程："+Thread.currentThread().getName());
                }
            } );
        }
    }
}
