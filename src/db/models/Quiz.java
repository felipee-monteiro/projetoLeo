package db.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class Quiz implements Model<Quiz> {

    private Connection cnx;
    private String categoria;
    private String nome;
    private String descricao;
    private String dica;
    private String tag;
    private String data;
    private String id;
    private int userId;
    private String username;
    private String user_created_at;

    public Quiz() {
    }

    public Quiz(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public void insert() {
        try {
            PreparedStatement st = this.cnx.prepareStatement("insert into Quiz (quiz_categoria, quiz_nome, quiz_desc, quiz_dica, quiz_tag, quiz_data, fk_Usuario_id_usuario, quiz_id) values (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, this.categoria);
            st.setString(2, this.nome);
            st.setString(3, this.descricao);
            st.setString(4, this.dica);
            st.setString(5, this.tag);
            st.setString(6, this.data);
            st.setInt(7, this.userId);
            st.setString(8, UUID.randomUUID().toString());
            st.execute();
        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public Quiz findOne(int id) {
        String sql = "SELECT * FROM Quiz q INNER JOIN Usuario u ON q.fk_Usuario_id_usuario = u.id_usuario";
        Quiz quiz = new Quiz();

        try {
            Statement st = this.cnx.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                String nome = result.getString("quiz_nome");
                String categoria = result.getString("quiz_categoria");
                String descricao = result.getString("quiz_desc");
                String dica = result.getString("quiz_dica");
                String tag = result.getString("quiz_tag");
                String data = result.getString("quiz_data");
                String username = result.getString("nome");
                String created_at = result.getString("created_at");

                quiz.setNome(nome);
                quiz.setCategoria(categoria);
                quiz.setDescricao(descricao);
                quiz.setDica(dica);
                quiz.setTag(tag);
                quiz.setData(data);
                quiz.setUsername(username);
                quiz.setUser_created_at(user_created_at);
            }
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
            System.exit(1);
        }

        return quiz;
    }

    @Override
    public ArrayList findAll() {
        ArrayList<Quiz> quizes = new ArrayList<Quiz>();
        String sql = "SELECT * FROM Quiz q INNER JOIN Usuario u ON q.fk_Usuario_id_usuario = u.id_usuario";

        try {
            Statement st = this.cnx.createStatement();
            ResultSet result = st.executeQuery(sql);
            Quiz quiz = new Quiz();

            while (result.next()) {
                String nome = result.getString("quiz_nome");
                String categoria = result.getString("quiz_categoria");
                String descricao = result.getString("quiz_desc");
                String dica = result.getString("quiz_dica");
                String tag = result.getString("quiz_tag");
                String data = result.getString("quiz_data");
                String username = result.getString("nome");
                String created_at = result.getString("created_at");

                quiz.setNome(nome);
                quiz.setCategoria(categoria);
                quiz.setDescricao(descricao);
                quiz.setDica(dica);
                quiz.setTag(tag);
                quiz.setData(data);
                quiz.setUsername(username);
                quiz.setUser_created_at(created_at);

                quizes.add(quiz);
            }
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
            System.exit(1);
        }

        return quizes;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Quiz WHERE id = " + id;

        try {
            Statement st = this.cnx.prepareStatement(sql);
            st.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    @Override
    public boolean update(int id, String senha) {
        String sql = "UPDATE Usuario SET senha = " + senha + " WHERE id_usuario = " + id;
        try {
            Statement st = this.cnx.prepareStatement(sql);
            st.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Quiz{" + "categoria=" + categoria + ", nome=" + nome + ", descricao=" + descricao + ", dica=" + dica + ", tag=" + tag + ", data=" + data + ", id=" + id + ", userId=" + userId + ", username=" + username + ", user_created_at=" + user_created_at + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_created_at() {
        return user_created_at;
    }

    public void setUser_created_at(String user_created_at) {
        this.user_created_at = user_created_at;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
