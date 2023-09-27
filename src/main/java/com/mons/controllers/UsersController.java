package com.mons.controllers;

import com.mons.entities.Users;
import com.mons.repositories.UsersRepository;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller("/users")
@Secured(SecurityRule.IS_ANONYMOUS)
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