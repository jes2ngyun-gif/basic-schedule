package com.sparta.basicschedule.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {

    private String title;
    private String writer;
    private String password;
}