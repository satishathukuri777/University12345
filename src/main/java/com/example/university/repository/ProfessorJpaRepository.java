/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.university.professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorJpaRepository extends JpaRepository<Professor, Long> {
    // Additional methods if needed
}
