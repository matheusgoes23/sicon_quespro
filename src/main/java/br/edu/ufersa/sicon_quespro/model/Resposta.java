package br.edu.ufersa.sicon_quespro.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_resposta")
public class Resposta implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
