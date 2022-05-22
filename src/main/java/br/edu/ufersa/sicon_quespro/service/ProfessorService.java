package br.edu.ufersa.sicon_quespro.service;

import br.edu.ufersa.sicon_quespro.model.Professor;
import br.edu.ufersa.sicon_quespro.model.User;
import br.edu.ufersa.sicon_quespro.model.UserEnum;
import br.edu.ufersa.sicon_quespro.repository.DisciplinaRepository;
import br.edu.ufersa.sicon_quespro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional(readOnly = true)
    public List<Professor> listar() {

        List<Professor> professores = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            if (user.getTipo().equals(UserEnum.PROFESSOR)) professores.add(toProfessor(user));
        });

        return professores;
    }

    @Transactional(readOnly = true)
    public Professor buscarPorId(Long id) throws Exception {

        var user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("Esse professor não existe!");
        } else if (!user.get().getTipo().equals(UserEnum.PROFESSOR)) {
            throw new Exception("Não é um professor!");
        } else {
            return toProfessor(user.get());
        }
    }

    @Transactional
    public Professor cadastrar(Professor professor) {
        return userRepository.save(professor);
    }

    @Transactional
    public Professor editar(Long id, Professor professor) throws Exception {
        buscarPorId(id);
        professor.setId(id);
        return userRepository.save(professor);
    }

    public void deletar(Long id) throws Exception {
        buscarPorId(id);

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Esse professor não pode ser deletado, pois está sendo usado!");
        }
    }

    private Professor toProfessor(User user) {
        Professor professor = new Professor();

        professor.setId(user.getId());
        professor.setNome(user.getNome());
        professor.setEmail(user.getEmail());
        professor.setLogin(user.getLogin());
        professor.setSenha(user.getSenha());
        professor.setDisciplinas(disciplinaRepository.findByProfessorId(user.getId()));
        professor.setTipo(UserEnum.PROFESSOR);

        return professor;
    }
}
