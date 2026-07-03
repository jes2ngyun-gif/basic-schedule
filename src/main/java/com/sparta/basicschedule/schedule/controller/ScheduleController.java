package com.sparta.basicschedule.schedule.controller;

import com.sparta.basicschedule.schedule.dto.ScheduleGetAllResponse;
import com.sparta.basicschedule.schedule.dto.ScheduleSaveRequest;
import com.sparta.basicschedule.schedule.dto.ScheduleSaveResponse;
import com.sparta.basicschedule.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetAllResponse>> getAll(
            @RequestParam(required = false) String writer
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll(writer));

    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleGetAllResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findById(id));
    }
}