package db.models;

import java.sql.*;
import java.util.ArrayList;

public class Usuario implements Model<Usuario> {

    private int id;
    private int idade;
    private String email;
    private String senha;
    private String created_at;
    private String nome;
    private Connection cnx;

    public Usuario() {
    }
    
    public Usuario(Connection cnx) {
        this.cnx = cnx;
    }

    public Usuario(Connection cnx, String nome, String email, String senha, int idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.cnx = cnx;
    }

    public Usuario(String nome, String email, String senha, int idade, String created_at) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.created_at = created_at;
    }

    /**
     *
     */
    @Override
    public boolean insert() {
        try {
            PreparedStatement st = this.cnx.prepareStatement("insert into Usuario(nome, email, senha, idade) values (?, ?, ?, ?)");
            st.setString(1, this.nome);
            st.setString(2, this.email);
            st.setString(3, this.senha);
            st.setInt(4, this.idade);
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario findOne(int id) {
        String query = "SELECT * FROM Usuario WHERE id_usuario = " + id;
        Usuario user = new Usuario();

        try {
            Statement st = this.cnx.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                int user_id = result.getInt("id_usuario");
                String created_at = result.getString("created_at");
                String nome = result.getString("nome");
                String email = result.getString("email");
                String senha = result.getString("senha");
                int idade = result.getInt("idade");

                user.setId(user_id);
                user.setNome(nome);
                user.setEmail(email);
                user.setIdade(idade);
                user.setSenha(senha);
                user.setCreated_at(created_at);
            }
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
            System.exit(1);
        }

        return user;
    }

    @Override
    public ArrayList findAll() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Usuario";

        try {
            Statement st = this.cnx.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id_usuario");
                String created_at = result.getString("created_at");
                String nome = result.getString("nome");
                String email = result.getString("email");
                String senha = result.getString("senha");
                int idade = result.getInt("idade");

                usuarios.add(new Usuario(nome, email, senha, idade, created_at));
            }
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
            System.exit(1);
        }
        return usuarios;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = " + id;

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

    public Usuario login() {
        String sql = "SELECT id_usuario FROM Usuario WHERE email = '" + this.email + "' AND senha = '" + this.senha + "'";
        Usuario user = new Usuario();

        try {
            Statement st = this.cnx.prepareStatement(sql);
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                int user_id = result.getInt("id_usuario");
                user.setId(user_id);
            }
        } catch (SQLException e) {
            System.out.println("ERRO DURANTE TENTATIVA DE RECUPERAÇÃO DE DADOS: " + e.getMessage());
        }
        return user;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", idade=" + idade + ", email=" + email + ", senha=" + senha + ", created_at=" + created_at + ", nome=" + nome + ", cnx=" + cnx + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

}
