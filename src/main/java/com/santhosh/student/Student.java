package com.santhosh.student;

/**
 * Represents a Student entity in the system.
 */
public class Student {
    private String id;
    private String name;
    private String grade;
    private String email;

    /**
     * Constructs a new Student.
     *
     * @param id    the unique ID of the student
     * @param name  the full name of the student
     * @param grade the grade or class the student is in
     * @param email the contact email of the student
     */
    public Student(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    /**
     * Gets the student's ID.
     *
     * @return the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id the new ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the student's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's grade.
     *
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the student's grade.
     *
     * @param grade the new grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the student's email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email.
     *
     * @param email the new email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
