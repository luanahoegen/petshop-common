package com.udesc.account.common.repository;

import com.udesc.account.common.entity.ClienteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<ClienteEntity> {

}
