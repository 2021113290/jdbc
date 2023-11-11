package threading;
public class printABC {
    /**
     * 有三个线程，分别只能打印A，B和C
     * 要求按顺序打印ABC，打印10次
     */
    public static void main(String[] args) throws InterruptedException {
        show();
    }

        private static void show() throws InterruptedException {
            for(int i=0;i<10;i++) {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("A");
                    }
                });
                t1.run();
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("B");
                    }
                });
                t2.run();
                Thread t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("C");
                    }
                });
                t3.run();
            }
        }
    }

