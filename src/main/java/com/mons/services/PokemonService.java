package com.mons.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mons.client.PokeApiClient;
import com.mons.dto.DetailedPokemonResponse;
import com.mons.dto.PokemonDTO;
import com.mons.dto.PokemonResponse;
import com.mons.entities.Pokemon;
import com.mons.entities.Types;
import com.mons.repositories.PokemonRepository;
import com.mons.repositories.TypesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class PokemonService {

    private static final Logger logger = LoggerFactory.getLogger(PokemonService.class);

    @Inject
    private final PokeApiClient pokeApiClient;
    private final PokemonRepository pokemonRepository;
    private final TypesRepository typesRepository;

    public PokemonService(PokemonRepository pokemonRepository, TypesRepository typesRepository,
            PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
        this.pokemonRepository = pokemonRepository;
        this.typesRepository = typesRepository;
    }

    public void fetchAndStorePokemon() {
        PokemonResponse response = pokeApiClient.getPokemon();
        for (PokemonResponse.PokemonResource resource : response.getResults()) {
            // Fetch detailed info for each Pokemon by using the URL or the name
            DetailedPokemonResponse detailedPokemon = pokeApiClient.getDetailedPokemon(resource.getName());

            if (detailedPokemon != null) {
                PokemonDTO pokemonDTO = new PokemonDTO();
                pokemonDTO.setName(detailedPokemon.getName());
                pokemonDTO.setHeight(detailedPokemon.getHeight());
                pokemonDTO.setWeight(detailedPokemon.getWeight());
                pokemonDTO.setBaseExperience(detailedPokemon.getBaseExperience());
                // ... potentially other fields
                addPokemon(pokemonDTO);
            } else {
                logger.error("Error fetching detailed info for Pokemon with name: " + resource.getName());
            }
        }
    }

    public void addPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setHeight(pokemonDTO.getHeight());
        pokemon.setWeight(pokemonDTO.getWeight());
        pokemon.setBaseExperience(pokemonDTO.getBaseExperience());

        List<Types> typeEntities = Optional.ofNullable(pokemonDTO.getTypes())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::findOrCreateType)
                .collect(Collectors.toList());

        pokemon.setTypes(typeEntities);

        // Use the save method provided by PokemonRepository to save the entity
        pokemonRepository.save(pokemon);
    }

    // TODO - Implement this method
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
