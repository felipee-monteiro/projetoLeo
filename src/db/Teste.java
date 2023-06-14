package db;

import java.sql.Connection;

public class Teste {
    public static void main(String[] args) {
        Connection cnx = new Conexao().abrirConexao();
    }
}
