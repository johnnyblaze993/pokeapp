package com.mons.controllers;

import com.mons.entities.Users;
import com.mons.repositories.UsersRepository;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/users")
public class UsersController {

    @Inject
    UsersRepository usersRepository;

    @Get(produces = MediaType.APPLICATION_JSON)
    public Iterable<Users> list() {
        return usersRepository.findAll();
    }

    @Post("/create")
    public Users create(@Body Users users) {
        return usersRepository.save(users);
    }
}