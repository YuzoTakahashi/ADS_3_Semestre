public class AlunoPos extends Aluno{
    private double Nota1;
    private double Nota2;
    private double notaMonografia;

    public AlunoPos(int ra, String nome, double nota1, double nota2, double notaMonografia) {
        super(ra, nome);
        Nota1 = nota1;
        Nota2 = nota2;
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calcularMedia() {
        return (Nota1 + Nota2 + notaMonografia) / 3;
    }

    @Override
    public String toString() {
        return "AlunoPos{" +
                "Nota1=" + Nota1 +
                ", Nota2=" + Nota2 +
                ", notaMonografia=" + notaMonografia +
                "} " + super.toString();
    }
}
