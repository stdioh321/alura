package br.com.stdioh.javadb;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public DataSource dataSource;

    public ConexaoFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:h2:~/db/h2.db");
        comboPooledDataSource.setUser("sa");
        comboPooledDataSource.setPassword("");
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection  getConnection() throws SQLException {


        return this.dataSource.getConnection();


    }
}
