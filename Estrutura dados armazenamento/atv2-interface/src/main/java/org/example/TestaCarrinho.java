package org.example;

import java.util.Scanner;

public class TestaCarrinho {
    public static Carrinho carrinho = new Carrinho();
    public static Scanner leitorNL = new Scanner(System.in);
    public static Scanner leitor = new Scanner(System.in);
    public static String resposta = "";
    public static void main(String[] args) {
        int opt = 0;

        while(opt!=6){
            System.out.println("=================================");
            System.out.println("|  1. Adicionar livro           |");
            System.out.println("|  2. Adicionar DVD             |");
            System.out.println("|  3. Adicionar servico         |");
            System.out.println("|  4. Exibir carrinho           |");
            System.out.println("|  5. Exibir total de vendas    |");
            System.out.println("|  6. Fim                       |");
            System.out.println("=================================");
            System.out.println("");
            System.out.print("Escolha uma das opções: ");
            opt = leitor.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Informe o código: ");
                    int codigoL = leitor.nextInt();
                    System.out.println("Informe o preço de custo: ");
                    double precoL = leitor.nextDouble();
                    System.out.println("Informe o nome do livro:");
                    String titulo = leitorNL.nextLine();
                    System.out.println("Informe o nome do autor:");
                    String autor = leitorNL.nextLine();
                    System.out.println("Informe o ISBN:");
                    String isbn = leitorNL.nextLine();

                    Livro l1 = new Livro(codigoL, precoL, titulo, autor, isbn);
                    carrinho.adicionaVendavel(l1);

                    break;
                case 2:
                    System.out.println("Informe o código: ");
                    int codigoD = leitor.nextInt();
                    System.out.println("Informe o preço de custo: ");
                    double precoD = leitor.nextDouble();
                    System.out.println("Informe o nome do DVD:");
                    String nomeDvd = leitorNL.nextLine();
                    System.out.println("Informe a gravadora:");
                    String gravadora = leitorNL.nextLine();

                    DVD dvd1 = new DVD(codigoD, precoD, nomeDvd, gravadora);

                    carrinho.adicionaVendavel(dvd1);
                    break;
                case 3:
                    System.out.println("Informe o código: ");
                    int codigoS = leitor.nextInt();
                    System.out.println("Informe a descrição do serviço:");
                    String descricao = leitorNL.nextLine();
                    System.out.println("Informe a quantidade de horas:");
                    int qtdHoras = leitor.nextInt();
                    System.out.println("Informe o valor hora:");
                    double valorHora = leitor.nextDouble();
                    Servico servico = new Servico(descricao, codigoS, qtdHoras, valorHora);
                    carrinho.adicionaVendavel(servico);
                    break;
                case 4:
                    carrinho.exibeItensCarrinho();
                    break;
                case 5:
                    System.out.printf("Total do carrinho: R$ %.2f\n" ,
                            carrinho.calculaTotalVenda());
            }
        }
        System.out.println("Fim...");
    }
}
