package com.sparta.basicschedule.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequest {

    private String title;
    private String content;
    private String writer;
    private String password;
}
