
public class ContaBancaria {
    private String nome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!!");
        } else {
            System.out.println("Valor do depósito inválido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!!");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public void pagarConta(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Pagamento de conta no valor de R$" + valor + " realizado com sucesso!!");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public void alterarInformacoes(String novoNome, String novoCpf) {
        setNome(novoNome);
        setCpf(novoCpf);
        System.out.println("Informações alteradas com sucesso!!");
    }
}

