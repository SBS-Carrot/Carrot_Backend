package com.carrot.backend.jobs.dto;

import lombok.Data;

@Data
public class JobsDto {
    String jobCategory;

    String jobSubject;

    String jobName;

    String jobPrice;

    String jobPlace;

    String jobDay;

    String jobStartTime;

    String jobEndTime;

    String jobContent;
}
