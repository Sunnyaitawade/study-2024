package com.study.corejava.controller;

import com.study.corejava.models.Student;
import com.study.corejava.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Avaruus Studios
 * @name StreamApiController
 * @date 7/9/2024
 */
@Tag(name = "StreamApi", description = "Core Java study APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/corejava/streampi")
public class StreamApiController {


    @Autowired
    private StudentService  studentService;

    @Operation(
            summary = "Retrieve list of students whose first name starts with alphabet A",
            description = "1- Find list of students whose first name starts with alphabet A",
            tags = { "StreamApi", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAllStudentNameA")
    public List<Student> getAllStudentNameA() {
        return studentService.findFirstNameWithAChar();
    }

}
