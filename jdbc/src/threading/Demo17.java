package threading;
//线程不安全：内存可见性问题
import java.util.Scanner;
//输入非0的数代码也不会结束，输入后内存已经被修改了，但是刚才的修改，对t1的读内存操作不会有影响；因为t1已经被优化为读一次就完了；t2把内存改了，t1没感知到--》内存可见性问题
public class Demo17 {
    static class Counter{
//        public int count=0;
       volatile public int count=0;
    }

    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread t1=new Thread(()->{
            while (counter.count==0){

            }
            System.out.println("t1执行结束");
        });
        t1.start();
        Thread t2=new Thread(()->{
            System.out.println("请输入一个int：");
            Scanner scanner=new Scanner(System.in);
            counter.count=scanner.nextInt();
        });
        t2.start();
    }
}
