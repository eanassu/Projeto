package br.com.vemprafam.pojo;

import java.util.Date;

public class Funcionario {
	private int re;
	private String nome;
	private double salario;
	private Date dataNascimento;
	public Funcionario() {
		super();
	}
	public Funcionario(int re, String nome, double salario, Date dataNascimento) {
		super();
		this.re = re;
		this.nome = nome;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
	}
	public int getRe() {
		return re;
	}
	public void setRe(int re) {
		this.re = re;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Funcionario [re=" + re + ", nome=" + nome + ", salario=" + salario + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
}
