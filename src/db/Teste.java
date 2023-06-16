package db;

import java.sql.Connection;
import db.models.Usuario;
import db.models.Quiz;
import org.json.JSONObject;

public class Teste {
    public static void main(String[] args) {
        Connection cnx = new Conexao().abrirConexao();
        Usuario user = new Usuario(cnx, "Felipe", "fm3209742@gmail.com", "123", 21);
        Quiz q = new Quiz(cnx);
        JSONObject perguntas = new JSONObject();  
        
        perguntas.put("title", "teste");
                
        q.setNome("Quiz teste");
        q.setCategoria("Geografia");
        q.setDescricao("Teste");
        q.setDica("dica");
        q.setData(perguntas.toString());
        q.setUserId(2);

        q.insert();

        for (Object quiz : q.findAll()) {
            System.out.println(quiz.toString());
        }

        user.insert();
        System.out.println(user.findOne(2));
        System.out.println(user.delete(1));
        System.out.println(user.update(22, "12345"));
    }
}
