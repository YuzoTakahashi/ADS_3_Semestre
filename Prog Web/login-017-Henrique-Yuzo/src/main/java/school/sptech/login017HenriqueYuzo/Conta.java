package school.sptech.login017HenriqueYuzo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Conta {
    private String usuario;
    private String senha;
    private String nome;

    private boolean isAutenticado;

    public Conta() {
    }

    public Conta(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.isAutenticado = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @JsonIgnore
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

    public boolean isAutenticado() {
        return isAutenticado;
    }

    public void setAutenticado(boolean autenticado) {
        isAutenticado = autenticado;
    }
}
