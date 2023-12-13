/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.university.student;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    Student createStudent(Student student);

    Student updateStudent(Long studentId, Student updatedStudent);

    void deleteStudent(Long studentId);
}
