package org.example;

import java.util.Objects;

public class Banco {

    // Atributos
    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);
    // Contador de operações empilhadas
    Integer contadorOperacao = 0;

    // Métodos

    /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
       Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void debitar(Double valor, ContaBancaria conta) {
        try {
            if (conta.debitar(valor)){
                Operacao o = new Operacao(conta, "Débito", valor);
                contadorOperacao++;

                pilhaOperacao.push(o);
            }
        } catch (IllegalArgumentException erro) {
        }

    }

    /* Método creditar - recebe o valor a ser depositado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void creditar(Double valor, ContaBancaria conta) {
        conta.creditar(valor);
        Operacao op = new Operacao(conta, "Depósito", valor);
        pilhaOperacao.push(op);
        contadorOperacao++;
    }

    /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
       Se essa quantidade for inválida, lança IllegalArgumentException
       Senão, "desfaz" a quantidade de operações passadas como argumento
       e atualiza o contadorOperacao
     */
    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
        if (qtdOperacaoDesfeita <= contadorOperacao && qtdOperacaoDesfeita > 0) {
            for (int i = 0; i < qtdOperacaoDesfeita; i++) {
                var conta = pilhaOperacao.pop();
                if (conta.getTipoOperacao().equals("Débito"))
                    conta.getContaBancaria().creditar(conta.getValor());
                if (conta.getTipoOperacao().equals("Depósito"))
                    conta.getContaBancaria().debitar((conta.getValor()));
                contadorOperacao--;
            }
        } else {
            throw new IllegalArgumentException("Operação inválida");
        }

    }


    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if (!tipoOperacao.equals("Débito") && !tipoOperacao.equals("Depósito"))
            throw new IllegalArgumentException();

        if (Objects.isNull(valor) || valor <= 0)
            throw new IllegalArgumentException();

        if (Objects.isNull(conta))
            throw new IllegalArgumentException();
        Operacao operacao = new Operacao(conta, tipoOperacao, valor);
        filaOperacao.insert(operacao);
    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {
        if (filaOperacao.isEmpty()) {
            System.out.println("Não existem operações agendadas");
        } else {
            while (!filaOperacao.isEmpty()) {
                filaOperacao.poll();
            }
        }
    }

    // Gettens
    public PilhaObj<Operacao> getPilhaOperacao() {
        return this.pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return this.filaOperacao;
    }

    public Integer getContadorOperacao() {
        return this.contadorOperacao;
    }
}
