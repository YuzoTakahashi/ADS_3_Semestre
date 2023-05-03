package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

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
    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {
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
            Aluno a = lista.get(i);
            corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFalta());
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
        String curso, ra, nome, disciplina;
        Double media;
        int qtdFalta;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        List<Aluno> listaLida = new ArrayList<>();

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
                    curso = registro.substring(2,7).trim();
                    ra = registro.substring(7,15).trim();
                    nome = registro.substring(15,65).trim();
                    disciplina = registro.substring(65,105).trim();
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.parseInt(registro.substring(110,113));
                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
                    contaRegDadosLidos++;

                    // Para importar essa informação ao banco de dados:
                    // repository.save(a);

                    // No nosso caso, como não estamos conectados a banco de dados
                    // vamos adicionar esse aluno a uma lista
                    listaLida.add(a);

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
        for (Aluno a : listaLida) {
            System.out.println(a);
        }

        // Se quiser importar a lista toda de uma vez para o banco:
        // repository.saveAll(listaLida);
    }

    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();
        lista.add(new Aluno("01221144","Vinicius Galdino","ADS",
                "Estrutura de Dados",9.5,6));
        lista.add(new Aluno("01221150","Andrey Rodrigues","ADS",
                "Engenharia de Software",6.0,3));
        lista.add(new Aluno("01221029","Lucas Oliveira","REDES",
                "Segurança da Informação",7.0,9));
        lista.add(new Aluno("01221149","Eduardo Francisco","CCO",
                "Análise de Algoritmos",8.0,0));
        lista.add(new Aluno("01221035","Matheus Nascimento","SIS",
                "Modelagem de Processos",10.0,1));
        lista.add(new Aluno("01221116","Yuri Leal","ADS",
                "Programação Web",8.5,12));

        System.out.println("Lista original:");
        for (Aluno a : lista) {
            System.out.println(a);
        }

//        gravaArquivoTxt(lista, "alunos.txt");
        leArquivoTxt("alunos.txt");
    }
}