package threading;
//一个线程针对一把锁，连续加锁两次
//第一次加锁，能够加锁成功；第二次加锁，就会加锁失败（锁已经被占用）
//在第二次加锁这里阻塞等待，等到第一把所被解锁，第二次加锁才能成功；
//第一把锁解锁，则要求执行完synchronized代码块，也就是要求第二把锁加锁成功
public class Demo16 {
    static class Counter{
        public synchronized void increase(){
            synchronized (this){
    //..
            }
        }
    }
    public static void main(String[] args) {
        threading.Counter counter=new threading.Counter();
        Thread t=new Thread(){
            @Override
            public void run() {
                counter.increase();
            }
        };
        t.start();
    }
}
