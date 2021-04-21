package br.com.stdioh.javadb.dao;

import br.com.stdioh.javadb.ConexaoFactory;
import br.com.stdioh.javadb.model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IBasicDao<Produto, Integer> {

    @Override
    public Produto findById(Integer id) throws SQLException {
        var conn = new ConexaoFactory().getConnection();
        var pst = conn.prepareStatement("SELECT * FROM produto WHERE id = ? LIMIT 1");
        pst.setInt(1, id);
        var result = pst.executeQuery();
        result.next();
        Produto prod = toEntity(result);
        conn.close();
        return prod;
    }

    @Override
    public List<Produto> findAll() throws SQLException {
        var conn = new ConexaoFactory().getConnection();
        var pst = conn.prepareStatement("SELECT * FROM produto");
        var result = pst.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (result.next()) {
            produtos.add(toEntity(result));
        }
        conn.close();
        return produtos;
    }

    @Override
    public Produto add(Produto produto) throws SQLException {
        var conn = new ConexaoFactory().getConnection();
        conn.setAutoCommit(false);
        var pst = conn.prepareStatement("INSERT INTO produto (nome, descricao) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, produto.getNome());
        pst.setString(2, produto.getDescricao());
        pst.executeUpdate();
        var result = pst.getGeneratedKeys();
        result.first();
        conn.commit();
        var prod = findById(result.getInt(1));

        conn.close();
        return prod;


    }

    @Override
    public Produto toEntity(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet.getString("nome"));
        return new Produto(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("descricao")
        );
    }

    @Override
    public boolean removeById(Integer id) throws SQLException {
        var conn = new ConexaoFactory().getConnection();
        conn.setAutoCommit(false);
        var pst = conn.prepareStatement("DELETE FROM produto WHERE id=?");
        pst.setInt(1, id);
        conn.commit();
        conn.close();
        return pst.executeUpdate() > 0 ? true : false;

    }
}
