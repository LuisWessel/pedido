package com.example.pedido.model;

import javax.persistence.*;

@Entity
@Table(name="TB_CLIENTE")
public class Cliente {

    @Id // Anotação id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Geração do id a responsabilidade do banco
    private Long id;

    private String nome;

    private String cod;

    public Long getId() {
        return id + 1 ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}

