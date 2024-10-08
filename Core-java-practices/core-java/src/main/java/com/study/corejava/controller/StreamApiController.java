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
import java.util.Map;

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
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAllStudentNameA")
    public List<Student> getAllStudentNameA() {
        return studentService.findFirstNameWithAChar();
    }

    @Operation(
            summary = "Group The Student By Department Names",
            description = "2- Group The Student By Department Names",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAllStudentByGroupDepartmentName")
    public Map<String,List<Student>> getAllStudentByGroupDepartments() {
        return studentService.groupByDepartName();
    }

    @Operation(
            summary = "Find the total count of student using stream",
            description = "3- Find the total count of student using stream",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAllStudentsCount")
    public String getAllStudentsCount() {
        return studentService.getCountOfStudents();
    }

    @Operation(
            summary = "Find the max age of student",
            description = "4- Find the max age of student",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getMaxAgeOfStudent")
    public String getMaxAgeOfStudent() {
        return studentService.getMaxAgeOfStudents();
    }

    @Operation(
            summary = "Find all departments names",
            description = "5- Find all departments names",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAllDepartmentNames")
    public List<String> getAllDepartmentNames() {
        return studentService.getAllDepartmentNames();
    }

    @Operation(
            summary = "Find the count of student in each department",
            description = "6- Find the count of student in each department",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getCountEachDepart")
    public Map<String,Long> getCountEachDepart() {
        return studentService.getCountEachDepartment();
    }

    @Operation(
            summary = "Find the list of students whose age is less than 30",
            description = "7- Find the list of students whose age is less than 30",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getStudenAgeLt")
    public List<Student> getListAgeLt() {
        return studentService.getListAgeLt();
    }

    @Operation(
            summary = "Find the list of students whose rank is in between 50 and 100",
            description = "8- Find the list of students whose rank is in between 50 and 100",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getRankBetween")
    public List<Student> getRankBt() {
        return studentService.geRankBt();
    }

    @Operation(
            summary = "Find the average age of male and female students",
            description = "9- Find the average age of male and female students",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAvgMlFml")
    public  Map<String,Double> getAvgAge() {
        return studentService.geAvgMlFml();
    }

    @Operation(
            summary = "Find the department who is having maximum number of students",
            description = "10- Find the department who is having maximum number of students",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getDepartmentByMaxStudent")
    public String getDptmntNmMxStd() {
        return studentService.getDptmntNmMxStd();
    }

    @Operation(
            summary = "Find the Students who stays in Delhi and sort them by their names",
            description = "11- Find the Students who stays in Delhi and sort them by their names",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getStdInDelhiSortName")
    public List<Student> getStdInDelhiSortName() {
        return studentService.getStdInDelhiSortName();
    }

    @Operation(
            summary = "Find the average rank in all departments",
            description = "12- Find the average rank in all departments",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAvgRankInAllDepart")
    public String getAvgRankInAllDepart() {
        return studentService.getAvgRankInAllDepart();
    }

    @Operation(
            summary = "Find the highest rank in each department",
            description = "13- Find the highest rank in each department",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getHighRankInEachDepart")
    public String getHighRankInEachDepart() {
        return studentService.getHighRankInEachDepart();
    }

    @Operation(
            summary = " Find the list of students and sort them by their rank",
            description = "14- Find the list of students and sort them by their rank",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getSortByRank")
    public  List<Student> getSortByRank() {
        return studentService.getSortByRank();
    }


    @Operation(
            summary = " Find the student who has second rank",
            description = "15- Find the student who has second rank",
            tags = { "StreamApi" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getStdHasSecondRank")
    public String getStdHasSecondRank() {
        return studentService.getStdHasSecondRank();
    }


}
