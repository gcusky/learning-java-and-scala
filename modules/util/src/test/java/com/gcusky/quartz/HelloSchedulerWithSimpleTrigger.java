package com.gcusky.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhy on 2018/7/13.
 */
public class HelloSchedulerWithSimpleTrigger {
    public static void main(String[] args) throws SchedulerException {
        // 打印当前的时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is: " + sf.format(date));
        // 创建一个JobDetail实例，将该实例与 HelloJob Class 绑定
        JobDetail jobDetail =
                JobBuilder.newJob(HelloJob1.class)
                        .withIdentity("myJob", "group1")
                        .usingJobData("massage", "hello myJob1")
                        .usingJobData("floatJobValue", 3.14F)
                        .build();
        // 获取距离当前时间3秒后的时间
        date.setTime(date.getTime() + 3000);
        // 获取距离当前时间6秒后的时间
        Date endDate = new Date();
        endDate.setTime(date.getTime() + 6000);
        // 创建一个Trigger实例，定义该job立即执行，并且每隔两秒执行一次
        SimpleTrigger trigger =
                TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "group1")
                        .usingJobData("message", "hello myTrigger1")
                        .usingJobData("doubleTriggerValue", 2.0D)
                        .startAt(date)
                        .endAt(endDate)
                        .withSchedule(
                                SimpleScheduleBuilder.simpleSchedule()
                                        .withIntervalInSeconds(2)
                                        .repeatForever()) // .withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
                        .build();
        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
