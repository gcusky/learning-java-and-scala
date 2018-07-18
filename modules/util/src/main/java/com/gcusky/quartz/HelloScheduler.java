package com.gcusky.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhy on 2018/7/13.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        // 创建一个JobDetail实例，将该实例与 HelloJob Class 绑定
        JobDetail jobDetail =
                JobBuilder.newJob(HelloJob.class)
                        .withIdentity("myJob", "group1")
                        .usingJobData("massage", "hello myJob1")
                        .usingJobData("floatJobValue", 3.14F)
                        .build();
        /**
         * System.out.println("jobDetail's name: " + jobDetail.getKey().getName());
         * System.out.println("jobDetail's group: " + jobDetail.getKey().getGroup());
         * System.out.println("jobDetail's jobClass: " + jobDetail.getJobClass().getName());
         */
        // 创建一个Trigger实例，定义该job立即执行，并且每隔两秒执行一次
        Trigger trigger =
                TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "group1")
                        .usingJobData("message", "hello myTrigger1")
                        .usingJobData("doubleTriggerValue", 2.0D)
                        .startNow()
                        .withSchedule(
                                SimpleScheduleBuilder.simpleSchedule()
                                        .withIntervalInSeconds(2)
                                        .repeatForever())
                        .build();
        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is: " + sf.format(date));
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
