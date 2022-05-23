package br.edu.ufersa.sicon_quespro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import br.edu.ufersa.sicon_quespro.model.Aluno;
import br.edu.ufersa.sicon_quespro.model.UserEnum;
import br.edu.ufersa.sicon_quespro.service.AlunoService;

@Service
public class DataSeeding implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		testeAluno();
	}
	@Autowired
	AlunoService aservice;
	public void testeAluno() {
		Aluno a = new Aluno();
		a.setLogin("teste");
		a.setNome("Joao");
		a.setSenha("1234");
		a.setTipo(UserEnum.ALUNO);
		
		aservice.cadastrar(a);
	}
}
