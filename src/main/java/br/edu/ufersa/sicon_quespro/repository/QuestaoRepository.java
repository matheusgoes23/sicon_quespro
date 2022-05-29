package br.edu.ufersa.sicon_quespro.repository;

import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    @Query("SELECT obj FROM Questao obj WHERE obj.temas = :tema")
    Questao findByTema(Tema tema);

}
