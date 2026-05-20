package com.telecom.platform.notification.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AttendanceConsumer {

    @RabbitListener(queues = "attendance.queue")
    public void consume(String employeeId) {

        System.out.println(
                "Notification sent for employee: " + employeeId
        );
    }
}