public class TesteAluno {
    public static void main(String[] args) {
        AlunoFundamental af1 = new AlunoFundamental(123, "Felix", 6, 6, 6, 6);

        AlunoGraduacao ag1 = new AlunoGraduacao(234, "Rosa", 6,3);

        AlunoPos ap1 = new AlunoPos(345, "Bolohno", 6,6,6);

        Escola e1 = new Escola("Sptech");

        e1.adicionaAluno(af1);
        e1.adicionaAluno(ag1);
        e1.adicionaAluno(ap1);

        e1.exibeTodos();
        System.out.println("=".repeat(20));
        e1.exibeAlunoGraduacao();
        System.out.println("=".repeat(20));
        e1.exibeAprovados();
        System.out.println("=".repeat(20));
        e1.buscaAluno(123);
        System.out.println("=".repeat(20));
        e1.buscaAluno(456);

    }
}
