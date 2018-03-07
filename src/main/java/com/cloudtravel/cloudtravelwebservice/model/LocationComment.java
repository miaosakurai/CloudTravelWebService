package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class LocationComment {
    private Integer locationCommentId;

    private Integer userId;

    private Integer star;

    private Date createTime;

    private String content;

    private String photo;
}