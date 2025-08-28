public class ContaCorrente extends Conta {

    public ContaCorrente(String agencia, int numero, Cliente titular) {
        super(agencia, numero, titular);
    }

    @Override
    public void sacar(double valor) {
        double taxa = 2.50;
        double total = valor + taxa;

        if (total <= saldo) {
            saldo -= total;
            historico.add(new Transacao("Saque com taxa", total));
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===== EXTRATO CONTA CORRENTE =====");
        super.imprimirExtrato();
    }
}
