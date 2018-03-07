package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Moment {
    private Integer momentId;

    private Integer userId;

    private Date createTime;

    private Integer status;

    private String content;

    private String photo;

}