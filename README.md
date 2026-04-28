# Student Management API

A simple and well-structured Maven Java project demonstrating core business logic for an in-memory student management system.

## Project Structure
```
.
├── pom.xml
├── README.md
├── .gitignore
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── santhosh
│   │               └── student
│   │                   ├── Main.java
│   │                   ├── Student.java
│   │                   ├── StudentRepository.java
│   │                   └── StudentService.java
│   └── test
│       └── java
│           └── com
│               └── santhosh
│                   └── student
│                       └── StudentServiceTest.java
```

## How to Build
To clean and build the project, run:
`mvn clean install`

## How to Run
To execute the main application:
`mvn exec:java`

## How to Test
To run the JUnit 5 test suite:
`mvn test`
