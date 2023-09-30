package com.mons.services;

import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mons.entities.Types;
import com.mons.repositories.PokemonRepository;
import com.mons.repositories.TypesRepository;
import com.mons.dto.PokemonDTO;
import com.mons.entities.Pokemon;

import jakarta.inject.Singleton;

@Singleton
public class PokemonService {

    @Inject
    PokemonRepository pokemonRepository;

    @Inject
    TypesRepository typesRepository;

    public void addPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        // ... set other fields like height, weight, base_experience, etc.

        List<Types> typeEntities = pokemonDTO.getTypes().stream()
                .map(this::findOrCreateType)
                .collect(Collectors.toList());

        pokemon.setTypes(typeEntities);

        pokemonRepository.save(pokemon);
    }

    private Types findOrCreateType(String typeName) {
        Optional<Types> existingType = typesRepository.findByName(typeName);
        return existingType.orElseGet(() -> {
            Types newType = new Types();
            newType.setName(typeName);
            return typesRepository.save(newType);
        });
    }

    // ... other methods related to fetching, updating, or deleting pokemons
}
