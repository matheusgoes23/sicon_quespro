package br.edu.ufersa.sicon_quespro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.sicon_quespro.model.Aluno;
import br.edu.ufersa.sicon_quespro.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunorepository;

	@Transactional(readOnly = true)
	public List<Aluno> listar() {

		List<Aluno> alunos = new ArrayList<>();

		alunos = alunorepository.findAll();

		return alunos;
	}

	@Transactional(readOnly = true)
	public Aluno findById(Long id) throws Exception {
		Optional<Aluno> aluno;
		aluno = alunorepository.findById(id);

		if (aluno.isEmpty()) {
			throw new Exception("Esse Aluno não existe!");
		} else {

			return aluno.get();
		}

	}

	@Transactional
	public Aluno cadastrar(Aluno aluno) {
		return alunorepository.save(aluno);
	}

	@Transactional
	public Aluno editar(Long id, Aluno aluno) throws Exception {
		Optional<Aluno> temp = alunorepository.findById(id);

		if (temp.isEmpty()) {
			throw new Exception("Esse Aluno não existe!");
		} else {
			return alunorepository.save(aluno);
		}
	}

	public void deletar(Long id) throws Exception {
		Aluno a = findById(id);
		if (a == null) {
			throw new Exception("Esse Aluno não existe!");
		} else {

			try {
				alunorepository.deleteById(id);
			} catch (Exception e) {
				throw new Exception("Esse Aluno não pode ser deletado");
			}
		}
	}
}
