
import java.util.Scanner;

public class MenuBanco {
    private Cliente cliente;

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n---- Menu Banco ----");
            System.out.println("1. Cadastrar");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    if (cliente != null) {
                        acessarConta(scanner);
                    } else {
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        cliente = new Cliente(nome, cpf, saldoInicial);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void acessarConta(Scanner scanner) {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n---- Conta de " + cliente.getNome() + " ----");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Pagar Conta");
            System.out.println("4. Verificar Saldo");
            System.out.println("5. Alterar Informações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    realizarSaque(scanner);
                    break;
                case 2:
                    realizarDeposito(scanner);
                    break;
                case 3:
                    pagarConta(scanner);
                    break;
                case 4:
                    verificarSaldo();
                    break;
                case 5:
                    alterarInformacoes(scanner);
                    break;
                case 6:
                    System.out.println("Saindo da conta...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void realizarSaque(Scanner scanner) {
        System.out.print("Valor do saque: ");
        double valorSaque = scanner.nextDouble();
        cliente.getConta().sacar(valorSaque);
    }

    private void realizarDeposito(Scanner scanner) {
        System.out.print("Valor do depósito: ");
        double valorDeposito = scanner.nextDouble();
        cliente.getConta().depositar(valorDeposito);
    }

    private void pagarConta(Scanner scanner) {
        System.out.print("Valor da conta a pagar: ");
        double valorPagamento = scanner.nextDouble();
        cliente.getConta().pagarConta(valorPagamento);
    }

    private void verificarSaldo() {
        System.out.println("Saldo atual: R$" + cliente.getConta().getSaldo());
    }

    private void alterarInformacoes(Scanner scanner) {
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo CPF: ");
        String novoCpf = scanner.nextLine();
        cliente.alterarInformacoes(novoNome, novoCpf);
    }
}
