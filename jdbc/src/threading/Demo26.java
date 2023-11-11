package threading;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

//实现定时器，体会多线程
//表示一个任务
class MyTask implements Comparable<MyTask>{

    private Runnable runnable;//    要执行的任务
    private long time;//什么时间来执行（时间戳）
    public MyTask(Runnable runnable,long delay){
        this.runnable=runnable;
        //delay中存的是绝对时间, 超过这个时间的任务就应该被执行
        this.time=System.currentTimeMillis()+delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time-o.time);// 谁的时间小谁排前面
    }
}
class Mytimer{
    private BlockingQueue<MyTask> queue=new PriorityBlockingQueue<>();
    private Object mailBox = new Object();//借助该对象的 wait / notify 来解决 while (true) 的忙等问题.
    public Mytimer(){
        //创建一个扫描线程,一直不停的扫描队首元素, 看看是否能执行这个任务
        Thread t=new Thread(()->{
        while (true){//while (true) 转的太快了, 造成了无意义的 CPU 浪费
            try {
//                去除队首元素
                MyTask task=queue.take();
                if (task.getTime()<=System.currentTimeMillis()){
                    //当前时间已经超过了设置的时间
                    task.getRunnable().run();//执行任务
                }else {
                    queue.put(task);
                    // [引入 wait] 等待时间按照队首元素的时间来设定
                    synchronized (mailBox) {
// 指定等待时间 wait
                        mailBox.wait(task.getTime()- System.currentTimeMillis());
                    }
                    //还没有到时间
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        });
        t.start();
    }
    public void schedule(Runnable runnable,long after) throws InterruptedException {
        MyTask mytask=new MyTask(runnable,after);
        queue.put(mytask);
        // [引入 notify] 每次有新的任务来了, 都唤醒一下 扫描线程, 检测下当前是否有
        synchronized (mailBox) {
            mailBox.notify();
        }
    }
}
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        Mytimer mytimer=new Mytimer();
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到！");
            }
        },3000);
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到！！");
            }
        },4000);
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到！！！");
            }
        },5000);
    }
}
