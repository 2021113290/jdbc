package threading;

public class Demo6 {
    public static final long COUNT=100_0000_000L;
    public static void main(String[] args) throws InterruptedException {
//            serial();
        concurrency();
    }
    //串行执行任务
    public static void serial(){
        long a=0;
        long begin=System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            a++;
        }
        a=0;
        for (int i = 0; i < COUNT; i++) {
            a++;
        }
        long end=System.currentTimeMillis();
        System.out.println("执行的时间间隔 "+(end-begin)+"ms");
    }
    //并行执行任务
    public static void concurrency() throws InterruptedException {
        long begin=System.currentTimeMillis();

        Thread t1=new Thread(()->{
            long a=0;
            for (int i = 0; i < COUNT; i++) {
                a++;
            }
        });
        Thread t2=new Thread(()->{
            long a=0;
            for (int i = 0; i < COUNT; i++) {
                a++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();//join阻塞等待线程结束，在main中调用t1.join效果就是 让main线程阻塞，一直到t1执行完，main才执行
        //t1,t2同时执行（宏观）
        long end=System.currentTimeMillis();
        System.out.println("执行的时间间隔 "+(end-begin)+"ms");
    }
}
