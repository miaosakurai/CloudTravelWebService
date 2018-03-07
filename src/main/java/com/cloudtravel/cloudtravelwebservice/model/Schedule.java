package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Schedule {
    private Integer scheduleId;

    private Integer userId;

    private Date date;

    private Integer priority;

    private Integer locationId;

    private String locationName;

    private String remark;


}