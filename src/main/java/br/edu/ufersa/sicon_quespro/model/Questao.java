package br.edu.ufersa.sicon_quespro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_questao")
public class Questao implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_questao_tema", joinColumns = @JoinColumn(name = "questao_id"), inverseJoinColumns = @JoinColumn(name = "tema_id"))
    Set<Tema> temas = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_resposta", joinColumns = @JoinColumn(name = "questao_id"))
    Set<String> respostas = new HashSet<>();

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

    public Set<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(Set<String> respostas) {
        this.respostas = respostas;
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

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", temas=" + temas +
                ", respostas=" + respostas +
                ", visibilidade=" + visibilidade +
                ", correta=" + correta +
                ", respondida=" + respondida +
                '}';
    }
}
