/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.university.course;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {

    List<Course> getAllCourses();

    Course getCourseById(Long courseId);

    Course createCourse(Course course);

    Course updateCourse(Long courseId, Course updatedCourse);

    void deleteCourse(Long courseId);
}
