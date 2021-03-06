package com.gcusky.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhy on 2018/7/13.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 打印当前的执行时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is: " + sf.format(date));
        // 编写具体的业务逻辑
        // System.out.println("Hello World!");
        JobKey key = context.getJobDetail().getKey();
        System.out.println("Job name -> key: " + key.getName() + "-> " + key.getGroup());
        TriggerKey trKey = context.getTrigger().getKey();
        System.out.println("Trigger name -> key: " + trKey.getName() + "-> " + trKey.getGroup());
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        JobDataMap trDataMap = context.getTrigger().getJobDataMap();
        // JobDataMap dataMap = context.getMergedJobDataMap(); // 相同 key 的情况下 trigger 会覆盖 job
        String jobMsg = dataMap.getString("message");
        Float jobFloatValue = dataMap.getFloat("floatJobValue");
        String triggerMsg = trDataMap.getString("message");
        Double triggerDoubleValue = trDataMap.getDouble("doubleTriggerValue");
        System.out.println("JobMsg is: " + jobMsg);
        System.out.println("JobFloatValue is: " + jobFloatValue);
        System.out.println("TriggerMsg is: " + triggerMsg);
        System.out.println("TriggerDoubleValue is: " + triggerDoubleValue);
    }
}
