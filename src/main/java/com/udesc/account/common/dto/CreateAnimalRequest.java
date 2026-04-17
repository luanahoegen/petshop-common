package com.udesc.account.common.dto;

import com.udesc.account.common.enumeration.AnimalEspecie;

public class CreateAnimalRequest {

    private String nome;
    private AnimalEspecie especie;
    private long idade;
    private Long clienteId;

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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
