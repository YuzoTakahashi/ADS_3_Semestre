package sptech.school.atv2s3pw.dto;

import sptech.school.atv2s3pw.dominio.Cliente;

public class PedidoDto {
    private String descricao;
    private Cliente cliente;
    private double valor;
    private Boolean finalizado;

    public PedidoDto(String descricao, Cliente cliente, double valor, Boolean finalizado) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
        this.finalizado = finalizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
}
