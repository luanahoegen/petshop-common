package com.udesc.account.common.service;

import com.udesc.account.common.dto.ClienteDTO;
import com.udesc.account.common.dto.CreateClienteRequest;
import com.udesc.account.common.entity.ClienteEntity;
import com.udesc.account.common.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class CreateCliente {

    private final ClienteRepository clienteRepository;

    public CreateCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteDTO criarCliente(CreateClienteRequest request) {
        validateRequest(request);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        clienteRepository.persistAndFlush(cliente);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }

    private void validateRequest(CreateClienteRequest request) {
        if (request.getNome() == null || request.getNome().isEmpty()) {
            throw new BadRequestException("Nome não pode ser nulo ou vazio");
        }
    }
}