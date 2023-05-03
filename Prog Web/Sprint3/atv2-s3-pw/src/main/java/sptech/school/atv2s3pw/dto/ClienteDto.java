package sptech.school.atv2s3pw.dto;

import sptech.school.atv2s3pw.dominio.Pedido;

import java.util.List;

public class ClienteDto {
    private String nome;
    private List<Pedido> pedidos;

    public ClienteDto(String nome, List<Pedido> pedidos) {
        this.nome = nome;
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
