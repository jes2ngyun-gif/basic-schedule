package com.sparta.basicschedule.schedule.service;

import com.sparta.basicschedule.schedule.dto.ScheduleGetAllResponse;
import com.sparta.basicschedule.schedule.dto.ScheduleSaveRequest;
import com.sparta.basicschedule.schedule.dto.ScheduleSaveResponse;
import com.sparta.basicschedule.schedule.entity.Schedule;
import com.sparta.basicschedule.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponse save(ScheduleSaveRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
       return new ScheduleSaveResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getWriter(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );

    }
    @Transactional(readOnly = true)
    public List<ScheduleGetAllResponse> findAll(String writer) {


        List<Schedule> schedules;

        if (writer == null || writer.isBlank()) {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        } else {
            schedules = scheduleRepository.findAllByWriterOrderByModifiedAtDesc(writer);
        }

        return schedules.stream()
                .map(schedule -> new ScheduleGetAllResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getWriter(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ))
                .toList();
    }
    @Transactional(readOnly = true)
    public ScheduleGetAllResponse findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. id=" + id));

        return new ScheduleGetAllResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getWriter(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }


}