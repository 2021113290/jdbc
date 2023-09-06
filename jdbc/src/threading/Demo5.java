package threading;
//lambda表达式,本质上是匿名函数，（）函数的形参，{}函数体
public class Demo5 {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            while (true){
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
    }
}
