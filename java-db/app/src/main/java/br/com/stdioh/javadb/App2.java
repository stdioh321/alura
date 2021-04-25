package br.com.stdioh.javadb;

import br.com.stdioh.javadb.dao.CategoriaDao;
import br.com.stdioh.javadb.dao.ProdutoDao;
import br.com.stdioh.javadb.model.Categoria;
import br.com.stdioh.javadb.model.Produto;
import br.com.stdioh.javadb.utils.Utils;

import java.sql.Connection;
import java.util.UUID;

public class App2 {
    public static void main(String[] args) {
        try (Connection conn = new ConexaoFactory().getConnection()) {
            conn.setAutoCommit(false);
            ProdutoDao produtoDao = new ProdutoDao(conn);
            CategoriaDao categoriaDao = new CategoriaDao(conn);
            var cat = categoriaDao.findById(2);

            produtoDao.findByCategoria(cat).forEach(produto ->
                    System.out.println(produto));
//            conn.commit();
        } catch (Exception ex) {
            System.out.println(ex.getClass().getName());
            ex.printStackTrace();
        }
    }
}
