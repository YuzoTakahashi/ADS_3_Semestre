import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void gravarArquivoCsv(ListaObj<Pokemon> dogs, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArquivo += ".csv";

        //Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            //Status(0) se der bom sai
            //Status(1) se der erro e sai
            System.exit(1);
        }
        //Bloco try-catch para gravar no arquivo
        try {
            for (int i = 0; i < dogs.getTamanho(); i++) {
                Pokemon pokemon = dogs.getElemento(i);
                saida.format("%d;%s;%d;%.1f;%s;%.1f;%s\n", pokemon.getID(), pokemon.getNome(), pokemon.getNumEvolucao(), pokemon.getPoder(), pokemon.getTipo(), pokemon.getExp(), pokemon.getRaridade());
            }
            System.out.println("Arquivo gerado com sucesso!!");
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo!");
            deuRuim = true;
            System.exit(1);
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void lerArquivoCsv(String nomeArquivo) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        //Bloco try-catch para abrir arquivo
        try {
            arq = new FileReader(nomeArquivo);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado!");
            System.exit(1);
        }

        //Bloco try-catch para ler o arquivo
        try {
            System.out.println("-".repeat(87));
            System.out.printf("|%4S | %-15S | %14S | %7S| %-9S | %7S | %-11S |\n", "id", "nome", "numevolucao", "poder", "tipo", "exp", "raridade");
            System.out.println("-".repeat(87));
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                String nome = entrada.next();
                int numEvolucao = entrada.nextInt();
                double poder = entrada.nextDouble();
                String tipo = entrada.next();
                double exp = entrada.nextDouble();
                String raridade = entrada.next();
                System.out.printf("|%4d | %-15s | %14d | %7.1f| %-9s | %7.1f | %-11s |\n", id, nome, numEvolucao, poder, tipo, exp, raridade);
            }
            System.out.println("-".repeat(87));
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problema!");
            deuRuim = true;
            System.exit(1);
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
            System.exit(1);
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        ListaObj<Pokemon> pokemon = new ListaObj(3);
        Scanner leitor = new Scanner(System.in);
        pokemon.adiciona(new Pokemon(1, "Pikachu", 1, 10.0, "Eletrico", 60.0, "Normal"));
        pokemon.adiciona(new Pokemon(2, "Giratina", 0, 60.0, "Fantasta", 45.0, "Lendario"));
        pokemon.adiciona(new Pokemon(3, "Dialga", 0, 60.0, "Dragão", 40.0, "Lendario"));

//        System.out.println("Nome do arquivo: ");
//        String nomeArq = leitor.next();
//        gravarArquivoCsv(pokemon, "pokedex");
        lerArquivoCsv("pokedex");
    }
}
