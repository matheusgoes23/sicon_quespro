package br.edu.ufersa.sicon_quespro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
@PrimaryKeyJoinColumn(name="id_user")
public class Aluno extends User {
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @ManyToMany(mappedBy = "alunos")
    Set<Disciplina> disciplinas = new HashSet<>();

    public Aluno() {
    	super(UserEnum.ALUNO);
    }
    
    public Aluno(Set<Disciplina> disciplinas) {
    	super(UserEnum.ALUNO);
		this.disciplinas = disciplinas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
