package level_26.Bobr_Refactoring.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        if (students == null || students.isEmpty()) return null;

        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student findStudent = null;

        for (Student student : students) {
            if (findStudent == null || student.getAverageGrade() > findStudent.getAverageGrade()) findStudent = student;
        }

        return findStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student findStudent = null;

        for (Student student : students) {
            if (findStudent == null || student.getAverageGrade() < findStudent.getAverageGrade()) findStudent = student;
        }

        return findStudent;
    }

    public void expel(Student student) {
        //TODO:
        if (student != null) students.remove(student);
    }
}