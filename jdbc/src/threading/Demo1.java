package threading;
class MyThread extends Thread{//Thread 标准库中提供的类，这个相当于对操作系统中的线程进行封装
    @Override//重写run方法，run里面的逻辑就是这个线程要执行的工作
    public void run() {
        while (true){
            System.out.println("hello thread!");
            try {
                Thread.sleep(1000);//让线程阻塞1000毫秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
//多线程的基本创建方式
public class Demo1 {//运行一次程序，就启动了一次进程
    //此代码，有两个线程，main线程，MyThread线程，两个线程并发执行

    public static void main(String[] args) throws InterruptedException {
        MyThread t=new MyThread();//创建实例，并不会在系统中真的创建一个线程
        t.start();//调用start方法时，才真的创建一个线程，新线程执行run里面的逻辑，直到run里面的代码执行完，新线程就运行结束

        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
