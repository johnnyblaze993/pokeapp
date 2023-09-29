package com.mons.controllers;

import com.mons.entities.Types;
import com.mons.repositories.TypesRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller("/types")
@Secured(SecurityRule.IS_ANONYMOUS)
public class TypesController {

    @Inject
    TypesRepository typesRepository;

    @Get(produces = MediaType.APPLICATION_JSON)
    public Iterable<Types> list() {
        return typesRepository.findAll();
    }

}