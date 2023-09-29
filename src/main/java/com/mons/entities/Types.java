package com.mons.entities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@Introspected
@MappedEntity("types")
public class Types {
    @Id
    private Integer typeId;

    private String name;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types() {
    }

    public Types(Integer typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

}