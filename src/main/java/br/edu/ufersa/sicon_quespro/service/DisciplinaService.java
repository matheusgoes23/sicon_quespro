package br.edu.ufersa.sicon_quespro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.sicon_quespro.model.Disciplina;
import br.edu.ufersa.sicon_quespro.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Transactional(readOnly = true)
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Disciplina buscarPorId(Long id) throws Exception {

		var disc = disciplinaRepository.findById(id);

		if (disc.isEmpty()) {
			throw new Exception("Esse tema não existe!");
		} else {
			return disc.get();
		}
	}

	@Transactional
	public Disciplina cadastrar(Disciplina disc) {
		return disciplinaRepository.save(disc);
	}

	@Transactional
	public Disciplina editar(Long id, Disciplina disc) throws Exception {
		if (buscarPorId(id) != null) {
			disc.setId(id);
			return disciplinaRepository.save(disc);
		}
		return null;
	}

}
