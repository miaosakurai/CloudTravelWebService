package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SearchHistory {
    private Integer searchHistoryId;

    private Integer userId;

    private String content;

    private Date createTime;
}