package br.com.stdioh.javadb.dao;

import lombok.Builder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public abstract class IBasicDao<E, ID> {
    public Connection connection;


    public IBasicDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<E> findAll() throws SQLException;

    public abstract E findById(ID id) throws SQLException;

    public abstract E add(E entity) throws SQLException;

    public abstract E toEntity(ResultSet resultSet) throws SQLException;

    public abstract boolean removeById(ID id) throws SQLException;
}
