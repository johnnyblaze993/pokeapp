package com.mons.controllers;

import com.mons.entities.Pokemon;
import com.mons.repositories.PokemonRepository;
import com.mons.services.PokemonService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.MediaType;

import java.util.List;

import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/pokemon")
public class PokemonController {
    private final PokemonRepository pokemonRepository;

    @Inject
    PokemonService pokemonService;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Get
    public List<Pokemon> getAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Post(uri = "/fetchAndStore", produces = MediaType.TEXT_PLAIN)
    public String fetchAndStore() {
        pokemonService.fetchAndStorePokemon();
        return "Successfully fetched and stored 151 Pokemon!";
    }
}
