/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.university.professor;

import com.example.university.course.Course;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String professorName;
    private String department;

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;

    // Constructors, getters, setters
}
