package com.sparta.basicschedule.schedule.controller;

import com.sparta.basicschedule.schedule.dto.ScheduleSaveRequest;
import com.sparta.basicschedule.schedule.dto.ScheduleSaveResponse;
import com.sparta.basicschedule.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> create(
            @RequestBody ScheduleSaveRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }
}