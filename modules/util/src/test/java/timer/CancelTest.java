package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by lizhy on 2018/7/6.
 */
public class CancelTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");

        Date startTime = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time is: " + sf.format(startTime));
        timer.schedule(task1, 3000, 2000);
        timer.schedule(task2, 1000, 2000);
        System.out.println("current canceled task number is: " + timer.purge());
        // 休眠5秒钟
        Thread.sleep(5000);

        Date cancelTime = new Date();
        System.out.println("cancel time is: " + sf.format(cancelTime));

        //-----------------cancel()----------------//
        // 取消所有任务
        //timer.cancel();
        //System.out.println("Tasks all canceled!");

        //-----------------purge()-----------------//
        task2.cancel();
        System.out.println("current canceled task number is: " + timer.purge());

    }
}
