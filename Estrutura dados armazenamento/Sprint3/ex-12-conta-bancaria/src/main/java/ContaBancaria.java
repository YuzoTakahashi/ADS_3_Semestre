public class ContaBancaria {
    private int numero;
    private double saldo;

    public ContaBancaria(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return String.format("Número: %.d \n Saldo: R$ %.2", this.numero, this.saldo);
    }

    public Boolean debitar(Double valor){
        if(this.saldo >= valor){
            saldo -= valor;
            System.out.printf("Saldo: R$ %.2f", this.saldo);
            return true;
        }else{
            System.out.printf("Saldo insuficiente");
            return false;
        }
    }
    public void creditar(Double valor){
        this.saldo += valor;
        System.out.printf("Saldo: R$ %.2f", this.saldo);
    }
}
