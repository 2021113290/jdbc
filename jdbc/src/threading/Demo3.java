package threading;
//使用匿名内部类，来创建Thread子类
public class Demo3 {
    public static void main(String[] args) {
        Thread t=new Thread(){//创建一个Thread的子类，同时实例化一个对象
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t.start();
    }
}
