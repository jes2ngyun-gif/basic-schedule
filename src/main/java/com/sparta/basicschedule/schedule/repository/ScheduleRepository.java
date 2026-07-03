package com.sparta.basicschedule.schedule.repository;

import com.sparta.basicschedule.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
