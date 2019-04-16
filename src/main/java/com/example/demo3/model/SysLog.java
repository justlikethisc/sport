package com.example.demo3.model;

import java.util.Date;


public class SysLog {

    private String requestClientIp;

    private String requestUrl;

    private String requestHttpMethod;

    private String requestClassMethod;

    //请求平台
    private String requestPlatform;

    private String requestParamData;

    private Date requestTime;

    private Date returnTime;

    private String returnDate;

    private String returnHttpStatusCode;

    //请求整体花费时间
    private String timeConsuming;

    private String requestSessionId;


    public String getRequestClientIp() {
        return requestClientIp;
    }

    public void setRequestClientIp(String requestClientIp) {
        this.requestClientIp = requestClientIp;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestHttpMethod() {
        return requestHttpMethod;
    }

    public void setRequestHttpMethod(String requestHttpMethod) {
        this.requestHttpMethod = requestHttpMethod;
    }

    public String getRequestClassMethod() {
        return requestClassMethod;
    }

    public void setRequestClassMethod(String requestClassMethod) {
        this.requestClassMethod = requestClassMethod;
    }

    public String getRequestPlatform() {
        return requestPlatform;
    }

    public void setRequestPlatform(String requestPlatform) {
        this.requestPlatform = requestPlatform;
    }

    public String getRequestParamData() {
        return requestParamData;
    }

    public void setRequestParamData(String requestParamData) {
        this.requestParamData = requestParamData;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnHttpStatusCode() {
        return returnHttpStatusCode;
    }

    public void setReturnHttpStatusCode(String returnHttpStatusCode) {
        this.returnHttpStatusCode = returnHttpStatusCode;
    }

    public String getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(String timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getRequestSessionId() {
        return requestSessionId;
    }

    public void setRequestSessionId(String requestSessionId) {
        this.requestSessionId = requestSessionId;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "requestClientIp='" + requestClientIp + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestHttpMethod='" + requestHttpMethod + '\'' +
                ", requestClassMethod='" + requestClassMethod + '\'' +
                ", requestPlatform='" + requestPlatform + '\'' +
                ", requestParamData='" + requestParamData + '\'' +
                ", requestTime=" + requestTime +
                ", returnTime=" + returnTime +
                ", returnDate='" + returnDate + '\'' +
                ", returnHttpStatusCode='" + returnHttpStatusCode + '\'' +
                ", timeConsuming='" + timeConsuming + '\'' +
                ", requestSessionId='" + requestSessionId + '\'' +
                '}';
    }
}
