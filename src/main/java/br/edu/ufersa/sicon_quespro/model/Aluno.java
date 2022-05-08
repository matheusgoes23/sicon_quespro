package br.edu.ufersa.sicon_quespro.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends User {
    public static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "alunos")
    Set<Disciplina> disciplinas = new HashSet<>();

    public Aluno() {
        super(UserEnum.ALUNO);
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
