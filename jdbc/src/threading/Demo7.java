package threading;

public class Demo7 {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            while (true){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"这是我的线程");
        //使用setDaemon设置为后台线程
        //设置操作得在start之前，如果线程启动。就改不了
        t.setDaemon(true);
        t.start();
        System.out.println("main线程执行结束");
    }
}
