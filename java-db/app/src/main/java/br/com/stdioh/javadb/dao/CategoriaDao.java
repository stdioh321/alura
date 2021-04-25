package br.com.stdioh.javadb.dao;

import br.com.stdioh.javadb.model.Categoria;
import br.com.stdioh.javadb.model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao extends IBasicDao<Categoria, Integer> {
    public CategoriaDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        var result = connection.createStatement().executeQuery("SELECT * FROM categoria");
        while (result.next()) {
            categorias.add(toEntity(result));
        }

        return categorias;
    }

    @Override
    public Categoria findById(Integer id) throws SQLException {
        var pst = connection.prepareStatement("SELECT * FROM categoria as c WHERE c.id = ?");
        pst.setInt(1, id);
        var result = pst.executeQuery();
        result.first();
        return toEntity(result);
    }

    @Override
    public Categoria add(Categoria entity) throws SQLException {
        var pst = connection.prepareStatement("INSERT INTO categoria(nome) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getNome());
        pst.executeUpdate();
        var result = pst.getGeneratedKeys();
        result.first();
        return findById(result.getInt(1));
    }

    @Override
    public Categoria toEntity(ResultSet resultSet) throws SQLException {
        return new Categoria(resultSet.getInt(1), resultSet.getString(2));
    }

    @Override
    public boolean removeById(Integer id) throws SQLException {
        var pst = connection.prepareStatement("DELETE FROM categoria WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
        return pst.executeUpdate() > 0;
    }
}
