public class AlunoGraduacao extends Aluno{
    private double Nota1;
    private double Nota2;

    public AlunoGraduacao(int ra, String nome, double nota1, double nota2) {
        super(ra, nome);
        Nota1 = nota1;
        Nota2 = nota2;
    }

    @Override
    public Double calcularMedia() {
        return (Nota1 * 0.4) + (Nota2 * 0.6);
    }

    @Override
    public String toString() {
        return "AlunoGraduacao{" +
                "Nota1=" + Nota1 +
                ", Nota2=" + Nota2 +
                "} " + super.toString();
    }
}
