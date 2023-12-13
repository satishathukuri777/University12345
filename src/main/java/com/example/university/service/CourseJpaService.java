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
package com.example.university.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseJpaService {

    private final CourseJpaRepository courseJpaRepository;

    @Autowired
    public CourseJpaService(CourseJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    public List<Course> getAllCourses() {
        return courseJpaRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseJpaRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));
    }

    public Course createCourse(Course course) {
        return courseJpaRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Course existingCourse = getCourseById(courseId);
        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setCredits(updatedCourse.getCredits());
        existingCourse.setProfessor(updatedCourse.getProfessor());
        existingCourse.setStudents(updatedCourse.getStudents());
        return courseJpaRepository.save(existingCourse);
    }

    public void deleteCourse(Long courseId) {
        courseJpaRepository.deleteById(courseId);
    }
}
