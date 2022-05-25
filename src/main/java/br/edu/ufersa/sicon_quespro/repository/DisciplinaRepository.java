package br.edu.ufersa.sicon_quespro.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.sicon_quespro.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Set<Disciplina> findByProfessorId(Long id);
}
