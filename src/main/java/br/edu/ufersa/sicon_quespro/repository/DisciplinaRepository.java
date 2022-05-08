package br.edu.ufersa.sicon_quespro.repository;

import br.edu.ufersa.sicon_quespro.model.Aluno;
import br.edu.ufersa.sicon_quespro.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Set<Disciplina> findByProfessorId(Long id);
}
