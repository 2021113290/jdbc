package threading;

public class Demo20 {
    public static void main(String[] args) {
//        专门准备一个对象，保证等待和通知是同一个对象
        Object object =new Object();
        //第一个线程：wait
        Thread t1=new Thread(()->{
           while (true){
               synchronized (object){
                   System.out.println("wait之前");
                   try {
                       object.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   //此处写的代码，一定是在notify之后执行的
                   System.out.println("wait之后");
               }
           }
        });
        t1.start();
        //第二个线程：notify
        Thread t2=new Thread(()->{
            while (true){
                synchronized (object){
                    System.out.println("notify之前");
        //此处写的代码，一定是在wait唤醒之前执行的
                        object.notify();
                    System.out.println("notify之后");
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
    }
}
