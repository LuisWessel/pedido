package com.example.pedido.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name="TB_NOTA")
/*@JsonIdentityInfo (generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")*/
public class Nota {
    @Id //Anotação para ID
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY Para Gerar Valor Id Automático
    private Long id;

    private String numero;

    @DateTimeFormat (pattern = "dd/MM/yyyy")
    private Date dataCriacao;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy="nota", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente nome) {
        this.cliente = nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }


}
