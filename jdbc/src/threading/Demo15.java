package threading;
//演示线程安全问题:下面代码线程安全
//加锁
class Counter1{
    public int count =0;
    //修饰方法
    public synchronized void increase(){
        count++;
    }
    public  Object locker=new Object();
    //修饰代码块
    public void increase1(){
        synchronized (locker){//用Counter内部特有的对象
            count++;
        }
        synchronized (this){//用this，谁调用了该方法，谁就是this
            count++;
        }

    }
}
public class Demo15 {
    private static Counter1 counter= new Counter1();

    public static void main(String[] args) throws InterruptedException {
        //搞两个线程，每个线程针对counter进行5w次自增
//        预期结果：10w
        Thread t1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("counter:"+counter.count);
    }
}
