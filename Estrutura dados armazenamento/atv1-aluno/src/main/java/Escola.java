import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Aluno> Alunos;

    public Escola(String nome) {
        this.nome = nome;
        Alunos = new ArrayList<Aluno>();
    }

    public void adicionaAluno(Aluno a){
        Alunos.add(a);
    }

    public void exibeTodos(){
        System.out.println("Todos os alunos: ");
        for (Aluno a: Alunos){
            System.out.println(a);
        }
    }

    public void exibeAlunoGraduacao(){
        System.out.println("Alunos graduação: ");
        for (Aluno a: Alunos){
            if(a instanceof AlunoGraduacao){
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados(){
        System.out.println("Alunos aprovados: ");
        for (Aluno a: Alunos){
            if(a.calcularMedia() >= 6){
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        System.out.println("Buscando aluno...");
        for (Aluno a: Alunos){
            if(a.getRa() == ra){
                System.out.println("Aluno encontrado:..");
                System.out.println(a);
                break;
            }
            else{
                System.out.println("Aluno não encontrado...");
                break;
            }
        }
    }
}
