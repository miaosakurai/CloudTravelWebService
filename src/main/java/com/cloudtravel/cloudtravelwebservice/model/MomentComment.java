package com.cloudtravel.cloudtravelwebservice.model;

import java.util.Date;

public class MomentComment {
    private Integer momentCommentId;

    private Integer momentId;

    private Integer commenterId;

    private Date createTime;

    private String content;

    public Integer getMomentCommentId() {
        return momentCommentId;
    }

    public void setMomentCommentId(Integer momentCommentId) {
        this.momentCommentId = momentCommentId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Integer getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Integer commenterId) {
        this.commenterId = commenterId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}