package threading;
//        题目名称：
//        请完成以下多线程编程：顺序打印
//        题目内容：
//        有三个线程，线程名称分别为：a，b，c。
//        每个线程打印自己的名称。
//        需要让他们同时启动，并按 c，b，a的顺序打印
public class Demo21 {
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
            },"a");
            t1.start();
            System.out.println(t1.getName());
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
            },"b");
            t2.start();
            System.out.println(t2.getName());

            Thread t3=new Thread(()->{
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
            },"c");
            t3.start();
            System.out.println(t3.getName());
        }
    }


