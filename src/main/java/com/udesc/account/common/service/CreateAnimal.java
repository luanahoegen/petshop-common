package com.udesc.account.common.service;

import com.udesc.account.common.dto.AnimalDTO;
import com.udesc.account.common.dto.CreateAnimalRequest;
import com.udesc.account.common.entity.AnimalEntity;
import com.udesc.account.common.entity.ClienteEntity;
import com.udesc.account.common.repository.AnimalRepository;
import com.udesc.account.common.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CreateAnimal {

    private final AnimalRepository animalRepository;
    private final ClienteRepository clienteRepository;

    public CreateAnimal(AnimalRepository animalRepository, ClienteRepository clienteRepository) {
        this.animalRepository = animalRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public AnimalDTO criarAnimal(CreateAnimalRequest request) {
        validateRequest(request);
        
        ClienteEntity cliente = clienteRepository.findByIdOptional(request.getClienteId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        AnimalEntity animal = new AnimalEntity();
        animal.setNome(request.getNome());
        animal.setEspecie(request.getEspecie());
        animal.setIdade(request.getIdade());
        animal.setCliente(cliente);
        
        animalRepository.persistAndFlush(animal);
        
        return new AnimalDTO(animal.getId(), animal.getNome(), animal.getEspecie(), animal.getIdade(), cliente.getId());
    }

    private void validateRequest(CreateAnimalRequest request) {
        if (request.getNome() == null || request.getNome().isEmpty()) {
            throw new BadRequestException("Nome do animal não pode ser nulo ou vazio");
        }
        if (request.getEspecie() == null) {
            throw new BadRequestException("Espécie do animal deve ser informada");
        }
        if (request.getClienteId() == null) {
            throw new BadRequestException("ID do cliente deve ser informado");
        }
    }
}
