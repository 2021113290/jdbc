package threading;
//有三个线程，分别只能打印A，B和C
//        要求按顺序打印ABC，打印10次
//        输出示例：
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
//        ABC
public class Demo22 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t1=new Thread(()->{
                System.out.println("A");
            });
            t1.start();
            t1.join();
            Thread t2=new Thread(()->{
                System.out.println("B");
            });
            t2.start();
            t2.join();
            Thread t3=new Thread(()->{
                System.out.println("C");
            });
            t3.start();
            t3.join();
        }
    }
}
