public class ContaPoupanca extends Conta {

    public ContaPoupanca(String agencia, int numero, Cliente titular) {
        super(agencia, numero, titular);
    }

    public void aplicarRendimento(double taxaPercentual) {
        double rendimento = saldo * (taxaPercentual / 100);
        depositar(rendimento);
        historico.add(new Transacao("Rendimento aplicado", rendimento));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===== EXTRATO CONTA POUPANÇA =====");
        super.imprimirExtrato();
    }
}
