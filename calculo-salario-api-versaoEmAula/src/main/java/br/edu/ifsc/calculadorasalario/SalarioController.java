package br.edu.ifsc.calculadorasalario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SalarioController {

		@RequestMapping(value = "/salario_liquido/{salarioBruto}", method = RequestMethod.GET)
		public double salarioLiquido(
				@PathVariable("salarioBruto") double salarioBruto) {
			Salario salarioLiquido = new Salario(salarioBruto);
			return salarioLiquido.calcularSalarioLiquido();
		}
	
		
		@RequestMapping(value = "/salario_liquido_dto/{salarioBruto}", method = RequestMethod.GET)
		public SalarioDTO salarioDTO(
				@PathVariable("salarioBruto") double salarioBruto) {
			Salario salario = new Salario(salarioBruto);
			SalarioDTO salarioDTO = new SalarioDTO(salario.getSalarioBruto(), salario.calcularDescontoIrpf(), salario.calcularDescontoInss(), salario.calcularSalarioLiquido());
			return salarioDTO;
		}
	}

