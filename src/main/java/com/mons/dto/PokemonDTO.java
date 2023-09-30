package com.mons.dto;

import java.util.List;

public class PokemonDTO {
    private String name;
    private List<String> types; // Assuming the types are just a list of names

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
