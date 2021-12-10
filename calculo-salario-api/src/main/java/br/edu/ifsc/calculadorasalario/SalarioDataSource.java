package br.edu.ifsc.calculadorasalario;

public class SalarioDataSource {
	
	public static Salario getSalario() {
		Salario salario = new Salario();
		return salario;
	}
	
	public static double getsalarioLiquido(double salarioBruto) {
		Salario salario = SalarioDataSource.getSalario();
		salario.setSalarioBruto(salarioBruto);
		double salarioLiquido = salario.calcularSalarioLiquido(salario.calcularDescontoIrpf(salario.getSalarioBruto()), salario.calcularDescontoInss(salario.getSalarioBruto()));
		return salarioLiquido;
		
	}
	

	public static SalarioDTO getSalarioDTO(double salarioBruto) {
		Salario salario = SalarioDataSource.getSalario();
		salario.setSalarioBruto(salarioBruto);
		SalarioDTO salarioDTO = new SalarioDTO(
				salario.getSalarioBruto(), 
				salario.calcularDescontoIrpf(salario.getSalarioBruto()), 
				salario.calcularDescontoInss(salario.getSalarioBruto()), 
				salario.calcularSalarioLiquido(salario.calcularDescontoIrpf(salario.getSalarioBruto()), salario.calcularDescontoInss(salario.getSalarioBruto())));
		return salarioDTO;
	}


}
