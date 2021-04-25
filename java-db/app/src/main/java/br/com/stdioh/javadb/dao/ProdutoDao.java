package br.com.stdioh.javadb.dao;

import br.com.stdioh.javadb.ConexaoFactory;
import br.com.stdioh.javadb.model.Categoria;
import br.com.stdioh.javadb.model.Produto;
import lombok.Builder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao extends IBasicDao<Produto, Integer> {

    public ProdutoDao(Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public Produto findById(Integer id) throws SQLException {
        var pst = this.connection.prepareStatement("SELECT * FROM produto as p WHERE id = ? INNERT JOIN categoria as c ON p.id_categoria = c.id LIMIT 1 ");
        pst.setInt(1, id);
        var result = pst.executeQuery();
        result.next();
        Produto prod = toEntity(result);
        return prod;
    }

    public List<Produto> findByCategoria(Categoria categoria) throws SQLException {
        var pst = this.connection.prepareStatement("SELECT * FROM produto as p  INNER JOIN categoria as c ON p.id_categoria = c.id WHERE p.id_categoria = ?");
        pst.setInt(1, categoria.getId());
        var result = pst.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (result.next()) {
            produtos.add(toEntity(result));
        }
        return produtos;
    }

    @Override
    public List<Produto> findAll() throws SQLException {
        var pst = this.connection.prepareStatement("SELECT * FROM produto as p JOIN categoria as c ON p.id_categoria = c.id ");
        var result = pst.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (result.next()) {
            produtos.add(toEntity(result));
        }
        return produtos;
    }

    @Override
    public Produto add(Produto produto) throws SQLException {
        var pst = this.connection.prepareStatement("INSERT INTO produto (nome, descricao, id_categoria) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, produto.getNome());
        pst.setString(2, produto.getDescricao());
        pst.setInt(3, produto.getCategoria().getId());
        pst.executeUpdate();
        var result = pst.getGeneratedKeys();
        result.first();
        var prod = findById(result.getInt(1));
        return prod;
    }

    @Override
    public Produto toEntity(ResultSet resultSet) throws SQLException {
        return new Produto(
                resultSet.getInt(1),
        resultSet.getString(2),
                resultSet.getString(3),
                new Categoria(resultSet.getInt(5), resultSet.getString(6))
        );
    }

    @Override
    public boolean removeById(Integer id) throws SQLException {
        var pst = this.connection.prepareStatement("DELETE FROM produto WHERE id=?");
        pst.setInt(1, id);
        return pst.executeUpdate() > 0 ? true : false;

    }
}
