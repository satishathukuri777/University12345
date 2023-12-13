/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.university.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseJpaService courseJpaService;

    @Autowired
    public CourseController(CourseJpaService courseJpaService) {
        this.courseJpaService = courseJpaService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseJpaService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseJpaService.getCourseById(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseJpaService.createCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course updatedCourse) {
        return courseJpaService.updateCourse(courseId, updatedCourse);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseJpaService.deleteCourse(courseId);
    }
}
