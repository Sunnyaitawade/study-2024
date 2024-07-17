package com.study.corejava.service;


import com.study.corejava.models.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
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

    /**
     * Method: 5- Find all departments names
     *
     */
    public List<String> getAllDepartmentNames() {
        return getAllStudents().stream().map(Student::getDepartmantName).toList();
    }

    /**
     * Method: 6- Find the count of student in each department
     *
     */
    public Map<String,Long> getCountEachDepartment(){
        return getAllStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));
    }

    /**
     * Method: 7- Find the list of students whose age is less than 30
     *
     */
    public List<Student> getListAgeLt() {
        return getAllStudents().stream().filter(student -> student.getAge()>30).toList();
    }

    /**
     * Method: 8- Find the list of students whose rank is in between 50 and 100
     *
     */
    public List<Student> geRankBt() {
        return getAllStudents().stream().filter(student -> student.getRank() > 30 && student.getRank()<50).toList();
    }

    /*
     * Method: 9- Find the average age of male and female students
     *
     */
    public Map<String,Double> geAvgMlFml() {
        return getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGender(),Collectors.averagingInt(value -> value.getAge())));
    }

    /*
     * 10- Find the department who is having maximum number of students
     *
     */
    public String  getDptmntNmMxStd() {
        return "Department having maximum number of students : "+ getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()
                )).entrySet().stream().max(Map.Entry.comparingByValue()).get();

    }

    /*
     * 11- Find the Students who stays in Delhi and sort them by their names
     *
     */
    public List<Student>  getStdInDelhiSortName() {
      return getAllStudents().stream().filter(student -> {
        return  student.getCity().equals("Delhi");
      }).sorted().toList();
    }

    /*
     * 12- Find the average rank in all departments
     *
     */
    public String  getAvgRankInAllDepart() {
        return " The average rank in all departments: " +getAllStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingDouble(Student::getRank)));
    }

    /*
     * 13- Find the highest rank in each department
     *
     */
    public String  getHighRankInEachDepart() {
        return " The highest rank in each department: " +getAllStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName,  Collectors.minBy(Comparator.comparing(Student::getRank))));
    }

    /*
     * 14- Find the list of students and sort them by their rank
     *
     */
    public List<Student>  getSortByRank() {
        return  getAllStudents().stream().sorted(Comparator.comparing(Student::getRank)).toList();
    }

    /*
     * 15- Find the student who has second rank
     *
     */
    public String  getStdHasSecondRank() {
        return  " The student who has second rank: " +getAllStudents().stream().sorted(Comparator.comparing(Student::getRank)).skip(1).limit(1).findFirst().get();
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
