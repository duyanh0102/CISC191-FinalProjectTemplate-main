package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentList {
    List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Student List:");
        synchronized (students) {
            students.forEach(System.out::println);
        }
    }

    public void convertToLambda() {
        Runnable runnable = () -> {
            System.out.println("Lambda thread is running");
            synchronized (students) {
                displayStudents();
            }
        };
        new Thread(runnable).start();
    }

    public void startServer(int port) {
        System.out.println("Server started on port " + port);
        // Implement your server logic here for listening on the given port
    }

    public List<String> getStudentNames() {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        Student student1 = new Student("John Cena");
        Student student2 = new Student("Jane Joe");
        Student student3 = new Student("Bob Rob");

        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);

        // Display student names using Stream API
        List<String> studentNames = studentList.getStudentNames();
        System.out.println("Student Names:");
        studentNames.forEach(System.out::println);

        // Convert displayStudents method to lambda
        studentList.convertToLambda();

        // Start server on multiple ports
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> studentList.startServer(8080));
        executorService.submit(() -> studentList.startServer(8081));

        // Shutdown the executor service
        executorService.shutdown();
    }
}
