package com.santhosh.student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class handling the business logic for student operations.
 */
public class StudentService {
    private final StudentRepository repository;

    /**
     * Constructs a new StudentService.
     *
     * @param repository the repository used for data operations
     */
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Adds a new student to the system.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if a student with the same ID already exists
     */
    public void addStudent(Student student) {
        if (student == null || student.getId() == null || student.getId().isEmpty()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        if (repository.findById(student.getId()) != null) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists");
        }
        repository.save(student);
    }

    /**
     * Removes a student from the system by their ID.
     *
     * @param id the unique ID of the student to remove
     * @return true if the student was successfully removed, false if not found
     */
    public boolean removeStudent(String id) {
        return repository.deleteById(id) != null;
    }

    /**
     * Finds a student by their ID.
     *
     * @param id the unique ID of the student
     * @return the Student if found, or null otherwise
     */
    public Student findById(String id) {
        return repository.findById(id);
    }

    /**
     * Lists all students currently in the system.
     *
     * @return a list of all students
     */
    public List<Student> listAll() {
        return repository.findAll();
    }

    /**
     * Finds students belonging to a specific grade.
     *
     * @param grade the grade to search for
     * @return a list of students in the specified grade
     */
    public List<Student> findByGrade(String grade) {
        if (grade == null) {
            return List.of();
        }
        return repository.findAll().stream()
                .filter(student -> grade.equals(student.getGrade()))
                .collect(Collectors.toList());
    }
}
