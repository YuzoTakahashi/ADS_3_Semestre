package school.sptech.login017HenriqueYuzo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Conta {
    private String usuario;
    private String senha;
    private String nome;

    private boolean isAutenticado;

    public Conta(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.isAutenticado = false;
    }
    public Conta() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    public boolean autenticar(String usuarioAutenticacao, String senhaAutenticacao){
            if(usuarioAutenticacao.equals(usuario) && senhaAutenticacao.equals((senha))){
                return  true;
            }
        return false;
    }
}
