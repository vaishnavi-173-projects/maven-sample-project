package com.santhosh.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the StudentService class.
 */
class StudentServiceTest {

    private StudentService studentService;
    private StudentRepository studentRepository;

    /**
     * Set up a fresh repository and service before each test.
     */
    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
    }

    /**
     * Test case 1: Test successfully adding a valid student.
     */
    @Test
    void testAddStudentSuccess() {
        Student student = new Student("101", "John Doe", "A", "john@example.com");
        studentService.addStudent(student);

        Student found = studentService.findById("101");
        assertNotNull(found, "Student should be found after being added");
        assertEquals("John Doe", found.getName(), "Name should match");
    }

    /**
     * Test case 2: Test attempting to add a student with a duplicate ID.
     */
    @Test
    void testAddStudentDuplicateIdThrowsException() {
        Student student1 = new Student("101", "John Doe", "A", "john@example.com");
        Student student2 = new Student("101", "Jane Doe", "B", "jane@example.com");

        studentService.addStudent(student1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            studentService.addStudent(student2);
        });

        assertTrue(exception.getMessage().contains("already exists"), "Exception message should indicate duplication");
    }

    /**
     * Test case 3: Test successfully removing an existing student.
     */
    @Test
    void testRemoveStudentSuccess() {
        Student student = new Student("102", "Alex Smith", "C", "alex@example.com");
        studentService.addStudent(student);

        boolean removed = studentService.removeStudent("102");
        assertTrue(removed, "Removal should be successful");

        assertNull(studentService.findById("102"), "Student should no longer be found");
    }

    /**
     * Test case 4: Test listing all students.
     */
    @Test
    void testListAll() {
        studentService.addStudent(new Student("1", "Alice", "A", "alice@example.com"));
        studentService.addStudent(new Student("2", "Bob", "B", "bob@example.com"));

        List<Student> students = studentService.listAll();
        assertEquals(2, students.size(), "Should correctly list all added students");
    }

    /**
     * Test case 5: Test finding students by a specific grade.
     */
    @Test
    void testFindByGrade() {
        studentService.addStudent(new Student("1", "Alice", "Grade 10", "alice@example.com"));
        studentService.addStudent(new Student("2", "Bob", "Grade 11", "bob@example.com"));
        studentService.addStudent(new Student("3", "Charlie", "Grade 10", "charlie@example.com"));

        List<Student> grade10Students = studentService.findByGrade("Grade 10");
        assertEquals(2, grade10Students.size(), "Should find exactly two students in Grade 10");

        List<Student> grade12Students = studentService.findByGrade("Grade 12");
        assertTrue(grade12Students.isEmpty(), "Should return empty list for grades with no students");
    }
}
