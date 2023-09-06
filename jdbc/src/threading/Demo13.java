package threading;
//java对PCB的状态规则
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            for (int i = 0; i < 10000_0000; i++) {

            }
        });;
//        t开始前
        System.out.println(t.getState());
        t.start();
//        Thread.sleep(500);
//        t正在工作
        System.out.println(t.getState());
        t.join();
//        t结束
        System.out.println(t.getState());
    }
}
