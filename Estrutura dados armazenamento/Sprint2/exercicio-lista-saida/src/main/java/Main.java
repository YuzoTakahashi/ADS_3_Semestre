import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Pokemon adicionar(){
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        System.out.println("Digite um ID:");
        int id = leitor.nextInt();
        System.out.println("Digite o nome do pokemon:");
        String nome = leitorNL.nextLine();
        System.out.println("Digite o numero de evoluções desse pokemon: ");
        int numEvolucao = leitor.nextInt();
        System.out.println("Digite o poder desse pokemon(Ex. 6,5)");
        double poder = leitor.nextDouble();
        System.out.println("Digite o tipo principal desse pokemon");
        String tipo = leitorNL.nextLine();
        System.out.println("Digite o numero de exp do pokemon(Ex. 6,5): ");
        double exp = leitor.nextDouble();
        System.out.println("Digite a raridade desse pokemon(Normal, raro ou lendário)");
        String raridade = leitorNL.nextLine();
        System.out.println("Pokemon adicionado :D");

        Pokemon pokemonNovo = new Pokemon(id, nome, numEvolucao, poder, tipo, exp, raridade);
        return pokemonNovo;
    }

    public static void exibir(ListaObj<Pokemon> pokemons){
        System.out.printf("-".repeat(106) + "\n");
        System.out.printf("| %-5S | %-15S | %-15S | %-7S | %-20S | %-7S | %-15S |\n", "ID","nome","numEvolução", "poder", "tipo", "exp", "raridade");
        System.out.printf("-".repeat(106) + "\n");
        for (int i = 0; i < pokemons.getTamanho(); i++) {
            Pokemon obj = pokemons.getElemento(i);
            System.out.printf("| %5d | %-15s | %15d | %7.2f | %-20s | %7.2f | %-15s |\n", obj.getID(), obj.getNome(), obj.getNumEvolucao(), obj.getPoder(), obj.getTipo(), obj.getExp(), obj.getRaridade());
            System.out.printf("-".repeat(106) + "\n");
        }
    }
    public static void main(String[] args) {
        ListaObj<Pokemon> pokemons = new ListaObj<>(5);
        Pokemon pokemonNovo = new Pokemon(1, "Pikachu", 1, 5.0, "Elétrico", 5.0, "Normal");
        Pokemon pokemonNovo1 = new Pokemon(1, "Giratina", 0, 100.0, "Fantasma", 100.0, "Lendário");
        pokemons.adiciona(pokemonNovo);
        pokemons.adiciona(pokemonNovo1);
        Scanner leitor = new Scanner(System.in);

        boolean Continue = true;
        while(Continue) {
            System.out.println("=".repeat(35));
            System.out.println("| Escolha uma das opções:         |");
            System.out.println("=".repeat(33));
            System.out.println("| 1. Adicioar um pokemon        |");
            System.out.println("=".repeat(33));
            System.out.println("| 2. Exibir pokemons cadastrados|");
            System.out.println("=".repeat(33));
            System.out.println("| 3. Sair                       |");
            System.out.println("=".repeat(33));
            int opt = leitor.nextInt();

            switch (opt){
                case 1:
                    pokemons.adiciona(adicionar());
                    break;
                case 2:
                    exibir(pokemons);
                    break;
                case 3:
                    Continue = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }

}
