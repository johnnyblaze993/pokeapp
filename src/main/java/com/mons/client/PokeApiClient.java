package com.mons.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mons.dto.PokemonResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

import jakarta.inject.Singleton;

@Singleton
public class PokeApiClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PokeApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public PokemonResponse getPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), PokemonResponse.class);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle exceptions appropriately.
        }
        return null; // Return null or throw an exception if API call fails
    }
}
