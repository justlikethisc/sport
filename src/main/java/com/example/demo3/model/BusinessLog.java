package com.example.demo3.model;


public class BusinessLog {

    private String opModule;

    private String opContent;

    //操作类型
    private int opType;

    private String requestClientIp;

    public String getOpModule() {
        return opModule;
    }

    public void setOpModule(String opModule) {
        this.opModule = opModule;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public String getRequestClientIp() {
        return requestClientIp;
    }

    public void setRequestClientIp(String requestClientIp) {
        this.requestClientIp = requestClientIp;
    }
}
