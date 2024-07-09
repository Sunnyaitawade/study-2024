package com.study.corejava.controller;

import com.study.corejava.models.Student;
import com.study.corejava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Avaruus Studios
 * @name StreamApiController
 * @date 7/9/2024
 */

@RestController
@RequestMapping("/api/corejava/streampi")
public class StreamApiController {


    @Autowired
    private StudentService  studentService;

    @GetMapping("/getAllStudentNameA")
    public List<Student> getAllStudentNameA() {
        return studentService.findFirstNameWithAChar();
    }

}
