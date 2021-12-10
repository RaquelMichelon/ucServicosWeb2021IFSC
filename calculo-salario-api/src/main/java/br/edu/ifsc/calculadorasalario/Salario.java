package br.edu.ifsc.calculadorasalario;

public class Salario {
	private double salarioBruto;
	
	public Salario() {
		
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	
	public Salario(double salarioBruto) {
		super();
		this.salarioBruto = salarioBruto;
	}

	
	public double calcularSalarioLiquido(double irpf, double inss) {
		double salarioLiquido = 0.0;
		salarioLiquido = salarioBruto - irpf - inss;
		return salarioLiquido;
	}
	
	public double calcularDescontoIrpf(double salarioBruto) {
		double irpf;
		if(salarioBruto > 4664.68) {
			irpf = (salarioBruto * 0.275) - 869.36;
		}
		else if(salarioBruto >  3751.05) {
			irpf = (salarioBruto * 0.225) - 636.13;
		}
		else if(salarioBruto >  2826.65) {
			irpf = (salarioBruto * 0.15) - 354.80;
		}
		else if(salarioBruto >  1903.98) {
			irpf = (salarioBruto * 0.075) - 142.80;
		}
		else {
			irpf = 0;
		}
		return irpf;
	}
	
	public double calcularDescontoInss(double salarioBruto) {
		double inss = 0.0;
		if(salarioBruto > 6101.06) {
			inss = (6101.06 * 0.14);
		}
		else if(salarioBruto <= 1045.00) {
			inss = (salarioBruto * 0.075);
		}
		else if(salarioBruto <= 2089.60) {
			inss = (salarioBruto * 0.09);
		}
		else if(salarioBruto <= 3134.40) {
			inss = (salarioBruto * 0.12);
		}
		else {
			inss = (salarioBruto * 0.14);
		}
		return inss;
	}
	

}
