package com.udesc.account.common.dto;

import com.udesc.account.common.entity.ClienteEntity;
import com.udesc.account.common.enumeration.AnimalEspecie;

public class AnimalDTO {

    private Long id;
    private String nome;
    private AnimalEspecie especie;
    private long idade;
    private ClienteEntity cliente;

    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String nome, AnimalEspecie especie, long idade, ClienteEntity cliente) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.cliente = cliente;
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

    public AnimalEspecie getEspecie() {
        return especie;
    }

    public void setEspecie(AnimalEspecie especie) {
        this.especie = especie;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
