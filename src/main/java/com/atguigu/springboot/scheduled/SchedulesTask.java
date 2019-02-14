package com.atguigu.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulesTask {

    //@Scheduled(cron = "0-4 * * * * *")
    public void taskMethod() {
        System.out.println("执行taskMethods");
    }

}
