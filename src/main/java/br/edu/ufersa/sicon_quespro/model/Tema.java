package br.edu.ufersa.sicon_quespro.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_tema")
public class Tema implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Tema(String nome) {
        this.nome = nome;
    }

    public Tema(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}