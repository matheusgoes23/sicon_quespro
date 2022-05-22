package br.edu.ufersa.sicon_quespro.service;

import br.edu.ufersa.sicon_quespro.model.Tema;
import br.edu.ufersa.sicon_quespro.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Transactional(readOnly = true)
    public List<Tema> listar() {
        return temaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Tema buscarPorId(Long id) throws Exception {

        var tema = temaRepository.findById(id);

        if (tema.isEmpty()) {
            throw new Exception("Esse tema não existe!");
        } else {
            return tema.get();
        }
    }

    @Transactional
    public Tema cadastrar(Tema tema) {
        return temaRepository.save(tema);
    }

    @Transactional
    public Tema editar(Long id, Tema tema) throws Exception {
        buscarPorId(id);
        tema.setId(id);
        return temaRepository.save(tema);
    }

    public void deletar(Long id) throws Exception {
        buscarPorId(id);

        try {
            temaRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Esse tema não pode ser deletado, pois está sendo usado!");
        }
    }
}
