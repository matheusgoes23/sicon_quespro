package br.edu.ufersa.sicon_quespro.repository;

import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
/*
<<<<<<< HEAD
public interface QuestaoRepository extends JpaRepository<Questao, Long> {	
	public Questao findByTemas(Tema tema);
=======*/
    @Query("SELECT obj FROM Questao obj WHERE obj.tema = :tema")
    Questao findByTema(Tema tema);
//>>>>>>> 2f78c05347b0beba58e2849bd5390a4f4ed69516

}
