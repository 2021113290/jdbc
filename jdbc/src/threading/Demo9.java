package threading;
class MyThread2 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Demo9 {
    public static void main(String[] args) {
        MyThread2 t=new MyThread2();
        t.run();
//        直接调用run并没有创建线程，只是在原来的线程中运行代码
//        调用start，则是创建了线程，在新线程中执行代码，和原来的线程是并发的
        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
