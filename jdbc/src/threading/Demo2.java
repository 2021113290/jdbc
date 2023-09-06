package threading;
//实现Runnable接口，重写run
class MyRunnable implements Runnable{
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
public class Demo2 {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread t=new Thread(runnable);
        t.start();
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
