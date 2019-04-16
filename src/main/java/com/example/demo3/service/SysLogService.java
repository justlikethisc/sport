package com.example.demo3.service;

import com.example.demo3.model.SysLog;
import org.springframework.stereotype.Component;

@Component
public class SysLogService {

    public void create(SysLog sysLog){
        System.out.println(sysLog.toString());
    }
}
