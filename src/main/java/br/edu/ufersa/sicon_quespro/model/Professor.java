package br.edu.ufersa.sicon_quespro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends User {
    public static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "professor")
    Set<Disciplina> disciplinas = new HashSet<>();

    public Professor() {
        super(UserEnum.PROFESSOR);
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
