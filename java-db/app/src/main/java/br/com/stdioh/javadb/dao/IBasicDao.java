package br.com.stdioh.javadb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IBasicDao<E, ID> {
    List<E> findAll() throws SQLException;

    E findById(ID id) throws SQLException;

    E add(E entity) throws SQLException;

    E toEntity(ResultSet resultSet) throws SQLException;
    boolean removeById(ID id) throws SQLException;
}
