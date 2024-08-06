package equalsandhashcode;/**
 * @name Student
 * @author NSA Studios
 * @date 7/29/2024
 */

import java.util.Objects;

/**
 * @name Student
 * @author NSA Studios
 * @date 7/29/2024
 */


public class Student {
 private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }


}
