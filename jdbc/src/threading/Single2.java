package threading;
//懒汉模式：提高效率
class SingletonLazy{
    //volatile禁止指令重排序
    private volatile static SingletonLazy instance=null;
    public static SingletonLazy getinstance(){
        if(instance==null) {//判定是否要加锁
            synchronized (SingletonLazy.class) {
                if (instance == null) {//判定是否要创建实例
                    instance = new SingletonLazy();//new操作可分为3个步骤，涉及指令重排序；那么如何禁止指令重排序--》volatile
                }
            }
        }
        return instance;
    }
    private SingletonLazy(){}
}
public class Single2 {
    public static void main(String[] args) {
        SingletonLazy instance=SingletonLazy.getinstance();
    }

}
