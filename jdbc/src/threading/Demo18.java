package threading;
//volaitle不保证原子性，只针对一个线程读另一个线程修改，对两个线程修改无能为力
public class Demo18 {
    static class Counter{
        volatile public int count=0;
        public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
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
        System.out.println(counter.count);
    }
}
