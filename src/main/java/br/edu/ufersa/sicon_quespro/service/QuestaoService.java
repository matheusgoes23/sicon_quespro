package br.edu.ufersa.sicon_quespro.service;

import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.repository.QuestaoRepository;
import br.edu.ufersa.sicon_quespro.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Transactional(readOnly = true)
    public List<Questao> listar() {
        return questaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Questao> listarPublicas() {

        List<Questao> questoes = questaoRepository.findAll();
        List<Questao> questoesPublicas = new ArrayList<>();

        questoes.forEach(questao -> {
            if (questao.isVisibilidade())
                questoesPublicas.add(questao);
        });

        return questoesPublicas;
    }

    @Transactional(readOnly = true)
    public Questao buscarPorId(Long id) throws Exception {

        var questao = questaoRepository.findById(id);

        if (questao.isEmpty()) {
            throw new Exception("Essa questão não existe!");
        } else {
            return questao.get();
        }
    }

    @Transactional
    public Questao cadastrar(Questao questao) {
        questao.getTemas().forEach(tema -> {
            if (tema.getId() != null) {
                questao.getTemas().remove(tema);
                questao.getTemas().add(temaRepository.getById(tema.getId()));
            }
        });

        return questaoRepository.save(questao);
    }

    @Transactional
    public Questao editar(Long id, Questao questao) throws Exception {
        buscarPorId(id);
        questao.setId(id);
        return questaoRepository.save(questao);
    }

    public void deletar(Long id) throws Exception {
        buscarPorId(id);

        try {
            questaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Essa questão não pode ser deletada, pois está sendo usada!");
        }
    }

    @Transactional
    public void tornarPublica(Long id, boolean visibilidade) throws Exception {
        Questao questao = buscarPorId(id);
        questao.setVisibilidade(visibilidade);
        questaoRepository.save(questao);
    }
}
