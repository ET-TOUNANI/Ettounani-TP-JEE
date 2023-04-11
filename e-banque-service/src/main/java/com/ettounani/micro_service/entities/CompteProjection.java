package com.ettounani.micro_service.entities;

import com.ettounani.micro_service.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class, name = "tounP1")
public interface CompteProjection {
    String getId();

    TypeCompte getType();
}
