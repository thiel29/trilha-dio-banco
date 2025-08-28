public class Main {
    public static void main(String[] args) {
        Cliente ana = new Cliente("Ana", "111.222.333-44");
        Cliente paula = new Cliente("Paula", "555.666.777-88");

        Conta contaAna = new ContaCorrente("001", 1001, ana);
        Conta contaPaula = new ContaPoupanca("001", 1002, paula);

        contaAna.depositar(1000);
        contaAna.sacar(150);
        contaAna.transferir(300, contaPaula);

        ((ContaPoupanca) contaPaula).aplicarRendimento(5); // 5% de rendimento

        contaAna.imprimirExtrato();
        contaPaula.imprimirExtrato();
    }
}
