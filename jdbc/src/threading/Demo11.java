package threading;

//设置让进程结束,使用标准库自带标志位
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            //currentTread 获取当前这个线程对应的Thread对象的引用
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t 线程执行完了！");
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        System.out.println("设置让线程结束");
    }
}
