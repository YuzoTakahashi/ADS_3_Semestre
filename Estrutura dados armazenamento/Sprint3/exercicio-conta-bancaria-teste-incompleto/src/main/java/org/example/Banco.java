package org.example;

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
        if (conta.debitar(valor)) {
            Operacao op = new Operacao(conta, "Depósito", valor);
            pilhaOperacao.push(op);
            filaOperacao.insert(op);
            contadorOperacao++;
        } else {
            throw new IllegalArgumentException("Depósito inválido");
        }
    }

    /* Método creditar - recebe o valor a ser depositado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void creditar(Double valor, ContaBancaria conta) {
        conta.creditar(valor);
        Operacao op = new Operacao(conta, "Creditar", valor);
        pilhaOperacao.push(op);
        filaOperacao.insert(op);
        contadorOperacao++;
    }

    /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
       Se essa quantidade for inválida, lança IllegalArgumentException
       Senão, "desfaz" a quantidade de operações passadas como argumento
       e atualiza o contadorOperacao
     */
    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
        if (qtdOperacaoDesfeita > 0) {
            for (int i = 0; i < qtdOperacaoDesfeita; i++) {
                pilhaOperacao.pop();
                filaOperacao.poll();
                contadorOperacao++;
            }
        }
        else{
            throw new IllegalArgumentException("Desfazer inválido");
        }
    }


    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if(valor >= 0) {
            if (tipoOperacao.equalsIgnoreCase("Débito")) {
                conta.debitar(valor);
                Operacao op = new Operacao(conta, tipoOperacao, valor);
                pilhaOperacao.push(op);
                filaOperacao.insert(op);
                contadorOperacao++;
            } else if (tipoOperacao.equalsIgnoreCase("Crédito")) {
                conta.creditar(valor);
                Operacao op = new Operacao(conta, tipoOperacao, valor);
                pilhaOperacao.push(op);
                filaOperacao.insert(op);
                contadorOperacao++;
            }
        }
        else{
            throw new IllegalArgumentException("Operação inválida");
        }
    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {

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
