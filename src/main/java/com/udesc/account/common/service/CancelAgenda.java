package com.udesc.account.common.service;

import com.udesc.account.common.dto.AgendaDTO;
import com.udesc.account.common.entity.AgendaEntity;
import com.udesc.account.common.enumeration.StatusAgendamento;
import com.udesc.account.common.repository.AgendaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CancelAgenda {

    private final AgendaRepository agendaRepository;

    public CancelAgenda(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Transactional
    public String cancelar(Long id) {
        AgendaEntity agenda = agendaRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Agendamento não encontrado"));

        if (StatusAgendamento.CANCELADO.equals(agenda.getStatus())) {
            return "Agendamento já está cancelado";
        }

        agenda.setStatus(StatusAgendamento.CANCELADO);
        agendaRepository.persistAndFlush(agenda);

        return "Agendamento cancelado com sucesso";
    }
}
