package br.senai.teste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private java.math.BigDecimal cpf;
    private java.math.BigDecimal fone;

    // Getters e Setters
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

    public java.math.BigDecimal getCpf() {
        return cpf;
    }

    public void setCpf(java.math.BigDecimal cpf) {
        this.cpf = cpf;
    }

    public java.math.BigDecimal getFone() {
        return fone;
    }

    public void setFone(java.math.BigDecimal fone) {
        this.fone = fone;
    }
}
