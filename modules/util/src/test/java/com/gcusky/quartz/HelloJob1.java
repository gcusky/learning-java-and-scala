package com.gcusky.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * quartz会自动根据getter/setter方法匹配
 * Created by lizhy on 2018/7/13.
 */
public class HelloJob1 implements Job {
    private String message;
    private Float floatJobValue;
    private Double doubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // 打印当前的执行时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is: " + sf.format(date));
        // 编写具体的业务逻辑
        // System.out.println("Hello World!");
        JobKey key = context.getJobDetail().getKey();
        System.out.println("Job [name -> key]: " + key.getName() + "-> " + key.getGroup());
        TriggerKey trKey = context.getTrigger().getKey();
        System.out.println("Trigger [name -> key]: " + trKey.getName() + "-> " + trKey.getGroup());
        // JobDataMap dataMap = context.getMergedJobDataMap(); // 相同 key 的情况下 trigger 会覆盖 job
        System.out.println("msg is: " + message);
        System.out.println("JobFloatValue is: " + floatJobValue);
        System.out.println("TriggerDoubleValue is: " + doubleTriggerValue);

        Trigger currentTrigger = context.getTrigger();
        System.out.println("Start Time Is: "+ sf.format(currentTrigger.getStartTime()));
        System.out.println("End Time Is: "+ sf.format(currentTrigger.getEndTime()));
    }
}
