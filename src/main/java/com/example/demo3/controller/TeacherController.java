package com.example.demo3.controller;

import com.example.demo3.model.TeacherDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @GetMapping("/{id}")
    public String getTeacher(@PathVariable String id){
        return id;
    }


    @GetMapping("/search")
    //http://localhost:8082/api/teacher/search?name=qqq
    //requestParamData='name=qqq'
    public String getTeacherByName(String name){
        return name;
    }

    @GetMapping("")
    //http://localhost:8082/api/teacher?name=qqq&no=11
    //requestParamData='name=qqq&no=11'
    public String getTeacherByCondition(TeacherDto teacherDto){
        return teacherDto.getName()+"-"+teacherDto.getNo();
    }
}
