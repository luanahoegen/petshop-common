package com.udesc.account.common.dto;

import com.udesc.account.common.enumeration.StatusAgendamento;
import com.udesc.account.common.enumeration.TipoServico;
import java.time.LocalDateTime;

public class AgendaDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String descricao;
    private Long animalId;
    private TipoServico tipoServico;
    private StatusAgendamento status;

    public AgendaDTO() {}

    public AgendaDTO(Long id, LocalDateTime dataHora, String descricao, Long animalId, TipoServico tipoServico, StatusAgendamento status) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.animalId = animalId;
        this.tipoServico = tipoServico;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}
