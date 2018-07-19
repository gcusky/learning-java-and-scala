package com.gcusky.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhy on 2018/7/13.
 */
public class HelloSchedulerWithCronTrigger {
    public static void main(String[] args) throws SchedulerException {
        // 打印当前的时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is: " + sf.format(date));
        // 创建一个JobDetail实例，将该实例与 HelloJob Class 绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob1.class).withIdentity("myJob").build();
        // 创建一个Trigger实例，定义该job立即执行，并且每隔两秒执行一次
        CronTrigger trigger =
                TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "group1")
                        .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                        .build();
        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

        // scheduler 执行两秒后挂起
        // Thread.sleep(2000L);
        // scheduler.standby();
        // scheduler 挂起三秒后继续执行
        // Thread.sleep(3000L);
        // scheduler.start();
    }
}
