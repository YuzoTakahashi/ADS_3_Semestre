import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void exibir(List<Pokemon> pokemons){
        System.out.printf("-".repeat(106) + "\n");
        System.out.printf("| %-5S | %-15S | %-15S | %-7S | %-20S | %-7S | %-15S |\n", "ID","nome","numEvolução", "poder", "tipo", "exp", "raridade");
        System.out.printf("-".repeat(106) + "\n");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon obj = pokemons.get(i);
            System.out.printf("| %5d | %-15s | %15d | %7.2f | %-20s | %7.2f | %-15s |\n", obj.getID(), obj.getNome(), obj.getNumEvolucao(), obj.getPoder(), obj.getTipo(), obj.getExp(), obj.getRaridade());
            System.out.printf("-".repeat(106) + "\n");
        }
    }
    public static void gravaRegistro (String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Bloco try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para gravar e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo");
        }
    }

    public static void gravaArquivoTxt(List<Pokemon> lista, String nomeArq) {
        int contaRegDadosGravados = 0;

        // Monta o registro de header
        String header = "00NOTA20231";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de dados ou registros de corpo
        String corpo;
        for (int i = 0; i < lista.size(); i++) {
            Pokemon p = lista.get(i);
            corpo = "02";
            corpo += String.format("%-2.2d", p.getID());
            corpo += String.format("%-15.15s", p.getNome());
            corpo += String.format("%-3.3s", p.getNumEvolucao());
            corpo += String.format("%-3.3s", p.getPoder());
            corpo += String.format("%-9.9s", p.getTipo());
            corpo += String.format("%3.3f", p.getExp());
            corpo += String.format("%8.8s", p.getRaridade());
            gravaRegistro(corpo, nomeArq);
            contaRegDadosGravados++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d",contaRegDadosGravados);
        gravaRegistro(trailer, nomeArq);
    }
    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, tipo, raridade;
        int id;
        int numEvolucao;
        double poder, exp;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        List<Pokemon> listaLida = new ArrayList<>();

        // try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // try-catch para ler e fechar o arquivo
        try {
            // le o 1o registro do arquivo
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2,6));
                    System.out.println("Ano e semestre: " + registro.substring(6,11));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(11,30));
                    System.out.println("Versão do documento: " + registro.substring(30,32));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegDadosGravados = Integer.parseInt(registro.substring(2,12));
                    if (qtdRegDadosGravados == contaRegDadosLidos) {
                        System.out.println("Quantidade de registros de dados gravados compatível com "
                                + "quantidade de registros de dados lidos");
                    }
                    else {
                        System.out.println("Quantidade de registros de dados gravados incompatível com "
                                + "quantidade de registros de dados lidos");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de dados ou corpo");
                    id = Integer.parseInt(registro.substring(3,5));
                    nome = registro.substring(6,21).trim();
                    numEvolucao = Integer.parseInt(registro.substring(22,25));
                    poder = Double.valueOf(registro.substring(26,29).replace(',', '.'));
                    tipo = registro.substring(30,39).trim();
                    exp = Double.valueOf(registro.substring(40, 43).replace(',','.'));
                    raridade = registro.substring(44,52).trim();
                    Pokemon p = new Pokemon(id, nome, numEvolucao, poder, tipo, exp, raridade);
                    contaRegDadosLidos++;

                    // Para importar essa informação ao banco de dados:
                    // repository.save(a);

                    // No nosso caso, como não estamos conectados a banco de dados
                    // vamos adicionar esse aluno a uma lista
                    listaLida.add(p);

                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }
                // le o próximo registro
                registro= entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
        }

        // Exibe a lista lida
        System.out.println("\nLista contendo os dados lidos do arquivo:");
        for (Pokemon p : listaLida) {
            System.out.println(p);
        }

        // Se quiser importar a lista toda de uma vez para o banco:
        // repository.saveAll(listaLida);
    }
    public static void main(String[] args) {
        List<Pokemon> pokemons = new ArrayList<>();        Pokemon pokemonNovo = new Pokemon(1, "Pikachu", 1, 5.0, "Elétrico", 5.0, "Normal");
        Pokemon pokemonNovo1 = new Pokemon(1, "Giratina", 0, 100.0, "Fantasma", 100.0, "Lendário");
        pokemons.add(pokemonNovo);
        pokemons.add(pokemonNovo1);
        Scanner leitor = new Scanner(System.in);

        boolean Continue = true;
        while(Continue) {
            System.out.println("=".repeat(35));
            System.out.println("| Escolha uma das opções:         |");
            System.out.println("=".repeat(33));
            System.out.println("| 1. Adicionar um pokemon        |");
            System.out.println("=".repeat(33));
            System.out.println("| 2. Exibir pokemons cadastrados |");
            System.out.println("=".repeat(33));
            System.out.println("| 3. Gerar arquivo TXT           |");
            System.out.println("=".repeat(33));
            System.out.println("| 4. Ler arquivo TXT             |");
            System.out.println("=".repeat(33));
            System.out.println("| 5. Sair                        |");
            System.out.println("=".repeat(33));
            int opt = leitor.nextInt();

            switch (opt){
                case 1:
                    pokemons.add(adicionar());
                    break;
                case 2:
                    exibir(pokemons);
                    break;
                case 3:
                    gravaArquivoTxt(pokemons, "pokemon.txt");
                    break;
                case 4:
                    leArquivoTxt("pokemon.txt");
                    break;
                case 5:
                    Continue = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }

}
