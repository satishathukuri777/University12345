/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.university.professor;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository {

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long professorId);

    Professor createProfessor(Professor professor);

    Professor updateProfessor(Long professorId, Professor updatedProfessor);

    void deleteProfessor(Long professorId);
}
