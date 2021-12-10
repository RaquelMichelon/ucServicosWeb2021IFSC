package br.edu.ifsc.calculadorasalario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SalarioController {

		//controller que faz uso do metodo calcular salario liquido da classe Salario
		@RequestMapping(value = "/salario_liquido/{salarioBruto}", method = RequestMethod.GET)
		public double salarioLiquido(
				@PathVariable("salarioBruto") double salarioBruto) {
			return SalarioDataSource.getsalarioLiquido(salarioBruto);
		}
	
		
		//controller que faz uso do metodo DTO
		@RequestMapping(value = "/salario_liquido_dto/{salarioBruto}", method = RequestMethod.GET)
		public SalarioDTO salarioDTO(
				@PathVariable("salarioBruto") double salarioBruto) {
			return SalarioDataSource.getSalarioDTO(salarioBruto);
		}
	}

