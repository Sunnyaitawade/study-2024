package com.study.corejava.service;


import com.study.corejava.models.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    /**
     * Method:     1- Find list of students whose first name starts with alphabet A
     */
    public List<Student> findFirstNameWithAChar() {
          return  getAllStudents().stream().filter(student -> {
            return student.getFirstName().startsWith("A");
        }).toList();
    }

    /**
     * Method: 2- Group The Student By Department Names
     */
    public  Map<String,List<Student>> groupByDepartName() {
       return  getAllStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName));
    }

    /**
     *Method: 3- Find the total count of student using stream
     *
     */
    public String getCountOfStudents() {
        return  "Total no of students : "+getAllStudents().stream().count();
    }

    /**
     *Method: 4- Find the max age of student
     *
     */
    public String getMaxAgeOfStudents() {
        return  "The max age of student is: "+getAllStudents().stream().mapToInt(Student::getAge).max().getAsInt();
    }


    public List<Student> getAllStudents() {
        return Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
    }

}
