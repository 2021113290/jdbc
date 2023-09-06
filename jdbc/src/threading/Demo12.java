package threading;
//线程等待
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        System.out.println("main线程join之前");
        t.join();//无限等待，可以加时间参数
        System.out.println("main线程join之后");
    }
}
