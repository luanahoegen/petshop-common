package com.udesc.account.common.repository;

import com.udesc.account.common.entity.AgendaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgendaRepository implements PanacheRepository<AgendaEntity> {

}
