package com.udesc.account.common.entity;

import com.udesc.account.common.enumeration.StatusAgendamento;
import com.udesc.account.common.enumeration.TipoServico;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
public class AgendaEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servico")
    private TipoServico tipoServico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusAgendamento status;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalEntity animal;

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

    public AnimalEntity getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalEntity animal) {
        this.animal = animal;
    }
}
