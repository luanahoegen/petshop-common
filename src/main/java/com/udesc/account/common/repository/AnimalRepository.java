package com.udesc.account.common.repository;

import com.udesc.account.common.entity.AnimalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<AnimalEntity> {

}
