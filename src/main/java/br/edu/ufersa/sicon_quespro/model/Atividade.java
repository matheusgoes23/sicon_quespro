package br.edu.ufersa.sicon_quespro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semestre;
    private String titulo;
    //@ManyToMany(cascade = {CascadeType.MERGE})
    //@JoinTable(name = "tb_atividade_questao",
    //        joinColumns = @JoinColumn(name = "atividade_id"),
    //        inverseJoinColumns = @JoinColumn(name = "questao_id"))
    @ManyToMany
	@JoinTable(name = "atividade_questao", joinColumns = @JoinColumn(name = "atividade_id"), inverseJoinColumns = @JoinColumn(name = "questao_id"))
    List<Questao> questoes;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    Disciplina disciplina;

    	
    public Atividade() {}
    public Atividade(String semestre, String titulo, List<Questao> questoes, Disciplina disciplina) {
		
		this.semestre = semestre;
		this.titulo = titulo;
		this.questoes = questoes;
		this.disciplina = disciplina;
	}

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

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    
}
