package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
public class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    public void setup() {
        studentList = new StudentList();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("John Cena");
        studentList.addStudent(student);

        List<Student> students = studentList.students;

        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(student, students.get(0));
    }

    @Test
    public void testGetStudentNames() {
        Student student1 = new Student("John Cena");
        Student student2 = new Student("Jane Joe");
        studentList.addStudent(student1);
        studentList.addStudent(student2);

        List<String> studentNames = studentList.getStudentNames();

        List<String> expectedNames = Arrays.asList("John Cena", "Jane Joe");
        Assertions.assertEquals(expectedNames, studentNames);
    }
}
