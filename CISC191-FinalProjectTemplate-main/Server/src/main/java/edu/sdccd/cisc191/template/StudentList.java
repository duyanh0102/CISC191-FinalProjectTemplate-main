package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Represents a list of students and provides operations for managing and interacting with the list.
 */
public class StudentList {
    List<Student> students;

    /**
     * Creates a new instance of StudentList with an empty list of students.
     */
    public StudentList() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student to the list.
     *
     * @param student the student to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Displays the list of students.
     */
    public void displayStudents() {
        System.out.println("Student List:");
        synchronized (students) {
            students.forEach(student -> System.out.println(student.getName()));
        }
    }

    /**
     * Converts the displayStudents method to a lambda expression and runs it on a separate thread.
     */
    public void convertToLambda() {
        Runnable runnable = () -> {
            System.out.println("Lambda thread is running");
            synchronized (students) {
                displayStudents();
            }
        };
        new Thread(runnable).start();
    }

    /**
     * Starts a server on the specified port.
     *
     * @param port the port number on which the server should listen
     */
    public void startServer(int port) {
        System.out.println("Server started on port " + port);
        // Implement your server logic here for listening on the given port
    }

    /**
     * Retrieves a list of student names.
     *
     * @return a list of student names
     */
    public List<String> getStudentNames() {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /**
     * Main method to demonstrate the usage of the StudentList class.
     *
     * @param args command-line arguments
     */
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
