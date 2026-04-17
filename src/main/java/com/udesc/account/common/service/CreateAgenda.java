package com.udesc.account.common.service;

import com.udesc.account.common.dto.AgendaDTO;
import com.udesc.account.common.dto.CreateAgendaRequest;
import com.udesc.account.common.entity.AgendaEntity;
import com.udesc.account.common.entity.AnimalEntity;
import com.udesc.account.common.enumeration.StatusAgendamento;
import com.udesc.account.common.repository.AgendaRepository;
import com.udesc.account.common.repository.AnimalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CreateAgenda {

    private final AgendaRepository agendaRepository;
    private final AnimalRepository animalRepository;

    public CreateAgenda(AgendaRepository agendaRepository, AnimalRepository animalRepository) {
        this.agendaRepository = agendaRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    public AgendaDTO agendar(CreateAgendaRequest request) {
        validateRequest(request);

        AnimalEntity animal = animalRepository.findByIdOptional(request.getAnimalId())
                .orElseThrow(() -> new NotFoundException("Animal não encontrado"));

        AgendaEntity agenda = new AgendaEntity();
        agenda.setDataHora(request.getDataHora());
        agenda.setDescricao(request.getDescricao());
        agenda.setTipoServico(request.getTipoServico());
        agenda.setStatus(StatusAgendamento.AGENDADO);
        agenda.setAnimal(animal);

        agendaRepository.persistAndFlush(agenda);

        return new AgendaDTO(
                agenda.getId(), 
                agenda.getDataHora(), 
                agenda.getDescricao(), 
                animal.getId(),
                agenda.getTipoServico(),
                agenda.getStatus()
        );
    }

    private void validateRequest(CreateAgendaRequest request) {
        if (request.getAnimalId() == null) {
            throw new BadRequestException("ID do animal deve ser informado");
        }
        if (request.getDataHora() == null) {
            throw new BadRequestException("Data e hora devem ser informadas");
        }
        if (request.getTipoServico() == null) {
            throw new BadRequestException("Tipo de serviço deve ser informado");
        }
    }
}
