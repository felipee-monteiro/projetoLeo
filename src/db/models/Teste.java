/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;

public class Teste {
    public void getAll(Connection cnx) {
        try {
            String query = "SELECT * FROM teste";
            Statement s = cnx.createStatement();
            ResultSet set = s.executeQuery(query);

            while (set.next()) {
                int id = set.getInt("id");
                String nome = set.getString("nome");
                System.out.printf("id: %d, nome: %s\n", id, nome);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar recuperar os dados");
        }
    }
}
