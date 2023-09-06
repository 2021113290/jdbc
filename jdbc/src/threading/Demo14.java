package threading;
//演示线程安全问题:下面代码线程不安全
//原因详见Demo14.png
class Counter{
    public int count =0;
    public void increase(){
        count++;
    }
}
public class Demo14 {
    private static Counter counter=new Counter();

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
