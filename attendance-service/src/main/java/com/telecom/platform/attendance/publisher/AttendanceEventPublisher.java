package com.telecom.platform.attendance.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendanceEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishCheckIn(String employeeId) {
        rabbitTemplate.convertAndSend(
                "attendance.exchange",
                "attendance.checkin",
                employeeId
        );
    }
}