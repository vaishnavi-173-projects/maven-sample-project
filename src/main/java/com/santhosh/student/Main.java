package com.santhosh.student;

import java.util.List;

/**
 * CLI Runner and demo entry point for the Student Management API.
 */
public class Main {

    /**
     * The main execution method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Initializing Student Management System...");

        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);

        System.out.println("Adding students...");
        service.addStudent(new Student("1", "Alice Smith", "A", "alice@example.com"));
        service.addStudent(new Student("2", "Bob Johnson", "B", "bob@example.com"));
        service.addStudent(new Student("3", "Charlie Davis", "A", "charlie@example.com"));

        System.out.println("\n--- All Students ---");
        List<Student> allStudents = service.listAll();
        for (Student s : allStudents) {
            System.out.println(s);
        }

        System.out.println("\n--- Students in Grade A ---");
        List<Student> gradeAStudents = service.findByGrade("A");
        for (Student s : gradeAStudents) {
            System.out.println(s);
        }

        System.out.println("\nFinding student with ID 2...");
        Student found = service.findById("2");
        System.out.println("Found: " + found);

        System.out.println("\nRemoving student with ID 1...");
        boolean removed = service.removeStudent("1");
        System.out.println("Removal successful: " + removed);

        System.out.println("\n--- Current Students After Removal ---");
        allStudents = service.listAll();
        for (Student s : allStudents) {
            System.out.println(s);
        }

        System.out.println("\nDemo completed application execution.");
    }
}
