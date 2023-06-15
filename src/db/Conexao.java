package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class Conexao {
    private Connection cnx;
    public Connection abrirConexao() {
        String url = "jdbc:mysql://localhost:3308/projetoLeo?useTimezone=true&serverTimezone=UTC";
        String username = "root";
        String password = "";

        try {
            cnx = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("ERRO AO TENTAR CONECTAR: " + e.getMessage());
        }

        return cnx;
    }
}