package com.mfe.quartz;

import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultTimer extends AbstractTimer {
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    @Override
    public void run(JobExecutionContext context) {
        System.out.println("DefaultTimer date is "+date);
        execute(date);
    }

    protected  void execute(String date){
        throw new RuntimeException();
    }
}
