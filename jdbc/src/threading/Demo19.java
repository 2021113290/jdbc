package threading;
//wait和notify
//线程执行到wait就会发生阻塞；直到另一个线程调用notify把这个wait唤醒，才会继续往下走
//wait操作的内部本质1.释放当前锁（前提是加了锁）2.进行等待通知3.满足一定的条件时（别人调用notify），被唤醒，然后尝试重新获取锁
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Object object=new Object();
        System.out.println("wait之前");
        object.wait();
        System.out.println("wait之后");
    }
}
