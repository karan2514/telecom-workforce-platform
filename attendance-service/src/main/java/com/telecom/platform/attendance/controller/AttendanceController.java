package com.telecom.platform.attendance.controller;

import com.telecom.platform.attendance.publisher.AttendanceEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceEventPublisher publisher;

    @PostMapping("/checkin/{employeeId}")
    public String checkIn(@PathVariable String employeeId) {

        publisher.publishCheckIn(employeeId);

        return "Attendance Marked";
    }
}