package threading;

//设置让进程结束
public class Demo10 {
    private static boolean isQuit=false;//自己定义线程是否结束的标记

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            while (!isQuit) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t 线程执行完了！");
        });
        t.start();
        Thread.sleep(3000);
        System.out.println("设置让线程结束");
    }
}
