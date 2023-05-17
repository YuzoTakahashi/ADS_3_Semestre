import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void exibirMenu() {

    }

    public static void main(String[] args) {
        PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
        FilaObj<Operacao> filaOperacao = new FilaObj(10);
        int contador = 0;
        int escolha = 0;
        List<ContaBancaria> contas = new ArrayList();
        contas.add(new ContaBancaria(1, 150.0));
        contas.add(new ContaBancaria(2, 200.0));

        while (escolha != 6) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Escolha uma dessas opções. ");
            System.out.println("1. Debitar valor");
            System.out.println("2. Creditar(Depositar) valor");
            System.out.println("3. Desfazer operação");
            System.out.println("4. Agendar operação");
            System.out.println("5. Executar operações agendadasa");
            System.out.println("6. Sair");
            escolha = leitor.nextInt();
            switch (escolha) {
                case 1:
                    Scanner leitorDebito = new Scanner(System.in);
                    System.out.println("Número da conta: ");
                    int numConta = leitorDebito.nextInt();
                    System.out.println("Valor: ");
                    double valor = leitorDebito.nextDouble();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumero() == numConta) {
                            try {
                                if (conta.debitar(valor)) {
                                    Operacao o = new Operacao(conta, "Débito", valor);
                                    contador++;
                                    pilhaOperacao.push(o);
                                }
                            } catch (IllegalArgumentException erro) {
                            }
                            break;
                        } else {
                            System.out.println("Conta não existe");
                            break;
                        }
                    }
                    break;
                case 2:
                    Scanner leitorDeposito = new Scanner(System.in);
                    System.out.println("Número da conta: ");
                    int numContaDeposito = leitorDeposito.nextInt();
                    System.out.println("Valor: ");
                    double valorDeposito = leitorDeposito.nextDouble();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumero() == numContaDeposito) {
                            conta.creditar(valorDeposito);
                            Operacao o = new Operacao(conta, "Crédito", valorDeposito);
                            contador++;
                            pilhaOperacao.push(o);
                            break;
                        } else {
                            System.out.println("Conta não existe");
                            break;
                        }
                    }
                    break;
                case 3:
                    Scanner leitorDesfazer = new Scanner(System.in);
                    System.out.println("Digite a quantidade de operações a serem desfeitas: ");
                    int qtdOperacaoDesfeita = leitorDesfazer.nextInt();
                    if (qtdOperacaoDesfeita <= contador && qtdOperacaoDesfeita > 0) {
                        for (int i = 0; i < qtdOperacaoDesfeita; i++) {
                            var conta = pilhaOperacao.pop();
                            if (conta.getTipoOperacao().equals("Débito"))
                                conta.getContaBancaria().creditar(conta.getValor());
                            if (conta.getTipoOperacao().equals("Depósito"))
                                conta.getContaBancaria().debitar((conta.getValor()));
                            contador--;
                        }
                    } else {
                        System.out.println("Operação inválida");
                    }
                    break;
                case 4:
                    Scanner leitorAgendar = new Scanner(System.in);
                    System.out.println("Digite a operação desejada(Débito ou Crédito): ");
                    String tipoOperacao = leitorAgendar.next();
                    System.out.println("Número da conta: ");
                    int numContaDAgendar = leitorAgendar.nextInt();
                    System.out.println("Valor: ");
                    double valorAgendar = leitorAgendar.nextDouble();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumero() == numContaDAgendar) {
                            if (!tipoOperacao.equals("Débito") && !tipoOperacao.equals("Depósito"))
                                throw new IllegalArgumentException();

                            if (Objects.isNull(valorAgendar) || valorAgendar <= 0)
                                throw new IllegalArgumentException();

                            if (Objects.isNull(conta))
                                throw new IllegalArgumentException();
                            Operacao operacao = new Operacao(conta, tipoOperacao, valorAgendar);
                            filaOperacao.insert(operacao);
                            break;
                        } else {
                            System.out.println("Conta não existe");
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Fim...");
                    break;
                default:
                    System.out.println("Digite opção válida ");
                    break;
            }
        }
    }
}
