package com.mons.repositories;

import com.mons.entities.Types;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TypesRepository extends CrudRepository<Types, Integer> {

}