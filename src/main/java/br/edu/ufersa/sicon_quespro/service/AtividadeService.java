package br.edu.ufersa.sicon_quespro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.sicon_quespro.model.Atividade;
import br.edu.ufersa.sicon_quespro.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	AtividadeRepository atividadeRepository;
    //@Autowired
    //private TemaRepository temaRepository;

    @Transactional(readOnly = true)
    public List<Atividade> listar() {
        return atividadeRepository.findAll();
    }



    @Transactional(readOnly = true)
    public Atividade buscarPorId(Long id) throws Exception {

        var atividade = atividadeRepository.findById(id);

        if (atividade.isEmpty()) {
            throw new Exception("Essa questão não existe!");
        } else {
            return atividade.get();
        }
    }

    @Transactional
    public Atividade cadastrar(Atividade atividade) {


        return atividadeRepository.save(atividade);
    }

    @Transactional
    public Atividade editar(Long id, Atividade atividade) throws Exception {
        buscarPorId(id);
        atividade.setId(id);
        return atividadeRepository.save(atividade);
    }

    public void deletar(Long id) throws Exception {
        buscarPorId(id);

        try {
            atividadeRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Essa atividade não pode ser deletada, pois está sendo usada!");
        }
    }

  
}
