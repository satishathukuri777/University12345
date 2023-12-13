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
package com.example.university.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorJpaService {

    private final ProfessorJpaRepository professorJpaRepository;

    @Autowired
    public ProfessorJpaService(ProfessorJpaRepository professorJpaRepository) {
        this.professorJpaRepository = professorJpaRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorJpaRepository.findAll();
    }

    public Professor getProfessorById(Long professorId) {
        return professorJpaRepository.findById(professorId)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor not found with ID: " + professorId));
    }

    public Professor createProfessor(Professor professor) {
        return professorJpaRepository.save(professor);
    }

    public Professor updateProfessor(Long professorId, Professor updatedProfessor) {
        Professor existingProfessor = getProfessorById(professorId);
        existingProfessor.setProfessorName(updatedProfessor.getProfessorName());
        existingProfessor.setDepartment(updatedProfessor.getDepartment());
        existingProfessor.setCourses(updatedProfessor.getCourses());
        return professorJpaRepository.save(existingProfessor);
    }

    public void deleteProfessor(Long professorId) {
        professorJpaRepository.deleteById(professorId);
    }
}
