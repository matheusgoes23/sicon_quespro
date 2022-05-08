package br.edu.ufersa.sicon_quespro.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semestre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_atividade_questao",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "questao_id"))
    Set<Questao> questoes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    Disciplina disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Set<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Set<Questao> questoes) {
        this.questoes = questoes;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
