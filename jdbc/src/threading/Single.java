package threading;
//饿汉模式
class Singleton{
    private  static Singleton instance=new Singleton();//类加载阶段就会创建实例“饿汉模式”
    public static Singleton getInstance(){
        return instance;
    }
    private  Singleton(){
        //把构造方法设为private，此时在类的外面就无法继续new实例了
//        这个操作强制禁止其他的类中new 实例
    }
}
public class Single {
    public static void main(String[] args) {
        Singleton instance=Singleton.getInstance();
    }
}
