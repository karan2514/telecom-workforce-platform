package com.telecom.platform.notification.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue attendanceQueue() {
        return new Queue("attendance.queue", true);
    }
}