package model.entities;

import model.exceptions.DomainException;

public class Conta {
	private Integer conta;
	private String titular;
	private double saldo;
	private double saqueLimite;

	public Conta() {

	}

	public Conta(Integer conta, String titular, double saldo, double saqueLimite) {
		this.conta = conta;
		this.titular = titular;
		this.saldo = saldo;
		this.saqueLimite = saqueLimite;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getSaque() {
		return saqueLimite;
	}

	public void setSaqueLimite(double saqueLimite) {
		this.saqueLimite = saqueLimite;
	}

	public void deposito(double deposito) {
		saldo += deposito;
	}

	public void saque(double saque) throws DomainException {
		if (saque > saqueLimite) {
			throw new DomainException("valor solicitado maior que o permitido");
		}
		if (saldo <= 0) {
			throw new DomainException("saldo insuficiente");
		}
		saldo -= saque;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titular: ");
		sb.append(titular);
		sb.append(" Saldo atual: $");
		sb.append(saldo);
		
		return sb.toString();
	}

}
