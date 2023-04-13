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

    public static void gravarArquivoCsv(ListaObj<Cachorro> dogs, String nomeArquivo) {
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
                Cachorro dog = dogs.getElemento(i);
                saida.format("%d;%s;%s;%.1f\n", dog.getId(), dog.getNome(), dog.getPorte(), dog.getPeso());
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
            System.out.println("-".repeat(43));
            System.out.printf("|%4S | %-15S | %-9S | %4S|\n", "id", "nome", "porte", "peso");
            System.out.println("-".repeat(43));
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                //NÃO UTILIZAR NEXTLINE(DÁ ERRO)
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                System.out.printf("|%4d | %-15s | %-9s | %4.1f|\n", id, nome, porte, peso);
//                System.out.println("-".repeat(43));
            }
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
        ListaObj<Cachorro> dogs = new ListaObj(7);
        Scanner leitor = new Scanner(System.in);
        dogs.adiciona(new Cachorro(1, "Dog1", "Pequeno", 10.0));
        dogs.adiciona(new Cachorro(2, "Dog2", "Medio", 20.0));
        dogs.adiciona(new Cachorro(3, "Dog3", "Grande", 30.0));
        dogs.adiciona(new Cachorro(4, "Dog4", "Pequeno", 40.0));
        dogs.adiciona(new Cachorro(5, "Dog5", "Medio", 50.0));
        dogs.adiciona(new Cachorro(6, "Dog6", "Grande", 60.0));
        dogs.adiciona(new Cachorro(7, "Dog7", "Pequeno", 70.0));

        System.out.println("Nome do arquivo: ");
//        String nomeArq = leitor.next();
//        gravarArquivoCsv(dogs, nomeArq);
        lerArquivoCsv("dog");
    }
}
