public class Operacao {
    private ContaBancaria contaBancaria;
    private String tipoOperacao;
    private double valor;

    public Operacao(ContaBancaria contaBancaria, String tipoOperacao, double valor) {
        this.contaBancaria = contaBancaria;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("\n----------Operação----------\n" +
                        "Tipo de operação: %s\n" +
                        "Valor da operação: R$%.2f",
                this.tipoOperacao, this.valor);
    }
}
