package br.edu.ufersa.sicon_quespro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_questao")
public class Questao implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_questao_tema", joinColumns = @JoinColumn(name = "questao_id"), inverseJoinColumns = @JoinColumn(name = "tema_id"))
    Set<Tema> temas = new HashSet<>();

    @OneToMany(mappedBy = "questao")
    Set<Resposta> respostas = new HashSet<>();

    @ManyToMany(mappedBy = "questoes")
    Set<Atividade> atividades = new HashSet<>();
    private boolean visibilidade;
    private int correta;
    private int respondida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Set<Tema> getTemas() {
        return temas;
    }

    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }

    public Set<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(Set<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public int getCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    public int getRespondida() {
        return respondida;
    }

    public void setRespondida(int respondida) {
        this.respondida = respondida;
    }
}
