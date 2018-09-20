package com.mfe.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintTimer extends DefaultTimer {
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @Override
    protected void execute(String date) {
        System.out.println("PrintTimer date is "+this.date);
    }
}
