
public class Cliente {
    private String nome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(String nome, String cpf, double saldoInicial) {
        this.nome = nome.toUpperCase();
        this.cpf = cpf;
        this.conta = new ContaBancaria(nome, cpf, saldoInicial);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void alterarInformacoes(String novoNome, String novoCpf) {
        this.setNome(novoNome);
        this.setCpf(novoCpf);
        System.out.println("Nome após alteração: " + this.nome);
        this.conta.alterarInformacoes(this.nome, novoCpf);
        System.out.println("Informações do cliente alteradas com sucesso.");
    }

}
