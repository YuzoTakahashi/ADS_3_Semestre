public class AlunoFundamental extends Aluno{
    private double Nota1;
    private double Nota2;
    private double Nota3;
    private double Nota4;

    public AlunoFundamental(int ra, String nome, double nota1, double nota2, double nota3, double nota4) {
        super(ra, nome);
        Nota1 = nota1;
        Nota2 = nota2;
        Nota3 = nota3;
        Nota4 = nota4;
    }

    @Override
    public Double calcularMedia() {
        return (Nota1 + Nota2 + Nota3 + Nota4) / 4;
    }

    @Override
    public String toString() {
        return "AlunoFundamental{" +
                "Nota1=" + Nota1 +
                ", Nota2=" + Nota2 +
                ", Nota3=" + Nota3 +
                ", Nota4=" + Nota4 +
                "} " + super.toString();
    }
}
