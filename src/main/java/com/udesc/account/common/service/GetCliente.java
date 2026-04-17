package com.udesc.account.common.service;

import com.udesc.account.common.dto.ClienteDTO;
import com.udesc.account.common.entity.ClienteEntity;
import com.udesc.account.common.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GetCliente {

    private final ClienteRepository clienteRepository;

    public GetCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO buscarPorId(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id);

        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        return toDTO(cliente);
    }

    private ClienteDTO toDTO(ClienteEntity cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }
}