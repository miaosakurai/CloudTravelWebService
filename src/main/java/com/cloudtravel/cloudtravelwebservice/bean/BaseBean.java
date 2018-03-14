package com.cloudtravel.cloudtravelwebservice.bean;

public class BaseBean {
    private String singleResult;

    public BaseBean() {
        singleResult = "";
    }

    public BaseBean(Object singleResult) {
        this.singleResult = singleResult.toString();
    }

    public String getSingleResult() {
        return singleResult;
    }

    public void setSingleResult(String singleResult) {
        this.singleResult = singleResult;
    }
}
