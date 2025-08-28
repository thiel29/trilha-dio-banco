import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String agencia;
    protected int numero;
    protected double saldo;
    protected Cliente titular;
    protected List<Transacao> historico = new ArrayList<>();

    public Conta(String agencia, int numero, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add(new Transacao("Depósito", valor));
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            historico.add(new Transacao("Saque", valor));
        }
    }

    public void transferir(double valor, Conta destino) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.saldo += valor;
            historico.add(new Transacao("Transferência para " + destino.titular.getNome(), valor));
            destino.historico.add(new Transacao("Transferência recebida de " + this.titular.getNome(), valor));
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirExtrato() {
        System.out.println("====================================");
        System.out.println("         EXTRATO BANCÁRIO           ");
        System.out.println("====================================");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("CPF: " + titular.getCpf());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("------------ Histórico -------------");
        for (Transacao t : historico) {
            System.out.println(t.getDescricao());
        }
        System.out.println("====================================\n");
    }
}
