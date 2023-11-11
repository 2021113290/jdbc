package threading;

import java.util.Timer;
import java.util.TimerTask;

//标准库定时器
public class Demo25 {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到！");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到！！");
            }
        },4000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到！！！");
            }
        },5000);
        System.out.println("开始计时！");
    }
}
