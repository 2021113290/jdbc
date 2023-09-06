package threading;

public class Demo8 {
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

        t.start();
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isDaemon());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
    }
}
