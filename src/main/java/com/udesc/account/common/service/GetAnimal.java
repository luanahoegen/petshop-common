package com.udesc.account.common.service;

import com.udesc.account.common.dto.AnimalDTO;
import com.udesc.account.common.entity.AnimalEntity;
import com.udesc.account.common.repository.AnimalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GetAnimal {

    private final AnimalRepository animalRepository;

    public GetAnimal(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalDTO buscarPorId(Long id) {
        AnimalEntity animal = animalRepository.findById(id);

        if (animal == null) {
            throw new NotFoundException("Animal não encontrado");
        }

        return toDTO(animal);
    }

    private AnimalDTO toDTO(AnimalEntity animal) {
        return new AnimalDTO(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getIdade(),
                animal.getCliente()
        );
    }
}