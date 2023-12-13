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
package com.example.university.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorJpaService professorJpaService;

    @Autowired
    public ProfessorController(ProfessorJpaService professorJpaService) {
        this.professorJpaService = professorJpaService;
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorJpaService.getAllProfessors();
    }

    @GetMapping("/{professorId}")
    public Professor getProfessorById(@PathVariable Long professorId) {
        return professorJpaService.getProfessorById(professorId);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorJpaService.createProfessor(professor);
    }

    @PutMapping("/{professorId}")
    public Professor updateProfessor(@PathVariable Long professorId, @RequestBody Professor updatedProfessor) {
        return professorJpaService.updateProfessor(professorId, updatedProfessor);
    }

    @DeleteMapping("/{professorId}")
    public void deleteProfessor(@PathVariable Long professorId) {
        professorJpaService.deleteProfessor(professorId);
    }
}
