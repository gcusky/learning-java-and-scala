package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by lizhy on 2018/7/3.
 */
public class MyTimer {
    public static void main(String[] args) {
        // 1. 创建一个timer实例
        Timer timer = new Timer();
        // 2. 创建一个MyTimerTask实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        /**
         * 获取当前时间，并设置成距离当前时间三秒后的时间
         */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current main time is: " + sf.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, 3);


        // 3. 通过timer定时定频率调用myTimerTask的业务逻辑

        //-------------------schedule的四种用法-------------------//
        /**
         * 在时间等于或超过time的时间执行且仅执行一次task
         */
        //myTimerTask.setName("schedule_1");
        //timer.schedule(myTimerTask, calendar.getTime());

        /**
         * 时间等于或超过time时首次执行task，之后每隔period毫秒重复执行一次task
         */
        //myTimerTask.setName("schedule_2");
        //timer.schedule(myTimerTask, calendar.getTime(), 2000);

        /**
         * 等待delay毫秒后执行且仅执行一次task
         */
        //myTimerTask.setName("schedule_3");
        //timer.schedule(myTimerTask, 1000);

        /**
         * 等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
         */
        //myTimerTask.setName("schedule_4");
        //timer.schedule(myTimerTask, 3000, 2000);

        //--------------scheduleAtFixedRate的两种用法-------------//
        /**
         * 时间等于或超过time时首次执行task，之后每隔period毫秒重复执行一次task
         */
        //myTimerTask.setName("scheduleAtFixedRate_1");
        //timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);

        /**
         * 等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
         */
        //myTimerTask.setName("scheduleAtFixedRate_2");
        //timer.scheduleAtFixedRate(myTimerTask, 3000, 2000);

        System.out.println("scheduled time is " + sf.format(myTimerTask.scheduledExecutionTime()));
    }
}
