package threading;
//        题目名称：
//        请完成以下多线程编程：顺序打印
//        题目内容：
//        有三个线程，线程名称分别为：a，b，c。
//        每个线程打印自己的名称。
//        需要让他们同时启动，并按 c，b，a的顺序打印
public class Demo21 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"c");

        Thread t2=new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"b");
        Thread t3=new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"a");
        t1.start();
        t2.start();
        t3.start();
    }
    }


