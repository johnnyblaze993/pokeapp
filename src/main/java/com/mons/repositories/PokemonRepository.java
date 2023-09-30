package com.mons.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import com.mons.entities.Pokemon;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}