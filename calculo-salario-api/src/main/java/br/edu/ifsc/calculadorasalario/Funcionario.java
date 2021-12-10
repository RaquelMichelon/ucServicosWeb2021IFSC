package br.edu.ifsc.calculadorasalario;

public class Funcionario {
	private int matricula;
	private String nome;
	private double salarioBruto;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public Funcionario(int matricula, String nome, double salarioBruto) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.salarioBruto = salarioBruto;
	}
	
	
}
