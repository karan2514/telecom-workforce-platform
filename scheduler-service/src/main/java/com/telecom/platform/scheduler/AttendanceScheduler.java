package com.telecom.platform.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AttendanceScheduler {

    @Scheduled(cron = "0 0 1 * * ?")
    public void generateDailyReport() {

        System.out.println("Generating attendance report...");
    }
}