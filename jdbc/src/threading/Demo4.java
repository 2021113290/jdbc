package threading;
//使用匿名内部类，实现Runnable接口的方式
public class Demo4 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {//匿名内部类的实例，作为构造方法的参数
            @Override
            public void run() {
                while (true){
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();
    }
}
