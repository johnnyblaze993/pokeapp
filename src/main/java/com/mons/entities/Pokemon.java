package com.mons.entities;

import java.util.List;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Transient;

@Introspected
@MappedEntity("pokemon") // maps to the "pokemon" table in your database
public class Pokemon {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer baseExperience;
    private Integer height;
    private Integer weight;

    @Transient // This annotation marks 'types' as not being a DB column
    private List<Types> types;

    // Constructors
    public Pokemon() {
        // Initialize the baseExperience with a default value, such as 0.
        // this.baseExperience = 0;
    }

    public Pokemon(Integer id, String name, Integer baseExperience, Integer height, Integer weight) {
        this.id = id;
        this.name = name;
        this.baseExperience = baseExperience;
        this.height = height;
        this.weight = weight;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

}
