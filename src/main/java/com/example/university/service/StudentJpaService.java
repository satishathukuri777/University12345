/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.university.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentJpaService {

    private final StudentJpaRepository studentJpaRepository;

    @Autowired
    public StudentJpaService(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    public List<Student> getAllStudents() {
        return studentJpaRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentJpaRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
    }

    public Student createStudent(Student student) {
        return studentJpaRepository.save(student);
    }

    public Student updateStudent(Long studentId, Student updatedStudent) {
        Student existingStudent = getStudentById(studentId);
        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourses(updatedStudent.getCourses());
        return studentJpaRepository.save(existingStudent);
    }

    public void deleteStudent(Long studentId) {
        studentJpaRepository.deleteById(studentId);
    }
}
