package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entre com os dados da conta:");
			System.out.print("Numero: ");
			int numero = sc.nextInt();
			System.out.print("Titular:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Saldo inicial:");
			double saldo_inicial = sc.nextDouble();
			System.out.print("Limite de saque:");
			double limite_saque = sc.nextDouble();

			Conta conta = new Conta(numero, nome, saldo_inicial, limite_saque);

			System.out.print("Quantidade que deseja sacar :");
			double saque = sc.nextDouble();
			conta.saque(saque);
			System.out.println();
			System.out.println(conta);

		} catch (DomainException e) {
			System.out.println();
			System.err.println("Erro na operação =>" + e.getMessage());
		}
		sc.close();
	}

}
