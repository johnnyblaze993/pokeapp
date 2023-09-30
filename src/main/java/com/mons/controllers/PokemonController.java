package com.mons.controllers;

import com.mons.entities.Pokemon;
import com.mons.repositories.PokemonRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/pokemon")
public class PokemonController {
    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Get
    public List<Pokemon> getAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }
}