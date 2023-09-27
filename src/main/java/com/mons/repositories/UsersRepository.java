package com.mons.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import com.mons.entities.Users;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UsersRepository extends CrudRepository<Users, Integer> {
    // Your methods here
}