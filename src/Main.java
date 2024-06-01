import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
        Banco b = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual seu nome?");
        String nome = scanner.nextLine();

		Cliente c = new Cliente();
		c.setNome(nome);
        Cliente c2 = new Cliente();
        c2.setNome("NOME 1");
		
        Conta acc;
        Conta acc2 = new ContaCorrente(c2);

        b.adicionaConta(acc2);

        System.out.println("Qual a conta? Corrente ou Poupança?");
        String conta = scanner.nextLine();
        if (conta.equals("Corrente"))
            acc = new ContaCorrente(c);
        else
            acc = new ContaPoupanca(c);

        b.adicionaConta(acc);
    
        double valor;
        while (true){
            System.out.print("[0] - Depositar dinheiro\n[1] - Sacar Dinheiro\n[2] - Transferência\n[3] - Pix\n[4] - Listar Contas\n[9] - Fim do programa\n");
            System.out.println("Qual função gostaria com sua conta?");
            int arg = scanner.nextInt();
            switch (arg){
                case 0:
                    System.out.println("Qual o valor do depósito?");
                    valor = scanner.nextDouble();
                    acc.depositar(valor);
                    break;
                case 1:
                    System.out.println("Qual o valor do saque?");
                    valor = scanner.nextDouble();
                    acc.sacar(valor);
                    break;
                case 2:
                    System.out.println("Qual o valor da transferência?");
                    valor = scanner.nextDouble();
                    acc.transferir(valor, acc2);
                    break;
                case 3:
                    System.out.println("Qual o valor do pix?");
                    valor = scanner.nextDouble();
                    acc.pix(valor, acc2);
                    break;
                case 4:
                    b.listarContas();
                    break;
                case 9:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Não há essa opção");
            }
        }
	}

}