package timer.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by lizhy on 2018/7/7.
 */
public class Executor {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is: " + sf.format(calendar.getTime()));

        DancingRobot dr = new DancingRobot();
        WaterRobot wr = new WaterRobot(timer);

        timer.schedule(dr, calendar.getTime(), 2000);
        timer.scheduleAtFixedRate(wr, calendar.getTime(), 1000);
    }
}
