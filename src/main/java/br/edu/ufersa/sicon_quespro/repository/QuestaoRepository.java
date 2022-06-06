package br.edu.ufersa.sicon_quespro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {	
	public Questao findByTemas(Tema tema);

}
