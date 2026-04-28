package com.santhosh.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory repository to manage Student data.
 */
public class StudentRepository {
    private final Map<String, Student> store;

    /**
     * Initializes a new StudentRepository with an empty underlying store.
     */
    public StudentRepository() {
        this.store = new HashMap<>();
    }

    /**
     * Saves a student in the repository.
     *
     * @param student the student to save
     */
    public void save(Student student) {
        if (student == null || student.getId() == null) {
            throw new IllegalArgumentException("Student and Student ID cannot be null");
        }
        store.put(student.getId(), student);
    }

    /**
     * Finds a student by their ID.
     *
     * @param id the unique ID of the student
     * @return the Student if found, or null otherwise
     */
    public Student findById(String id) {
        return store.get(id);
    }

    /**
     * Removes a student by their ID.
     *
     * @param id the unique ID of the student to remove
     * @return the removed Student, or null if none existed with that ID
     */
    public Student deleteById(String id) {
        return store.remove(id);
    }

    /**
     * Retrieves a list of all students.
     *
     * @return a List of all students
     */
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * Clears the repository. Useful for testing.
     */
    public void clear() {
        store.clear();
    }
}
