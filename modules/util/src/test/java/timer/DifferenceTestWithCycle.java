package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lizhy on 2018/7/7.
 */
public class DifferenceTestWithCycle {
    public static void main(String[] args) {
        // 规定时间格式
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前的具体时间
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current time is: " + sf.format(calendar.getTime()));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // timer.scheduleAtFixedRate
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印当前的计划执行时间
                System.out.println("Scheduled exec time is: " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);
    }
}
