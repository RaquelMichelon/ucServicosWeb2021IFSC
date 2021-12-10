package br.edu.ifsc.cambio;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CotacaoMoedaController {
	
	@RequestMapping(value = "/converter_moeda/{valor}/{tipoMoeda}/{tipoOperacao}", method = RequestMethod.GET)
	public Double converterMoeda(
			@PathVariable(name = "valor") double valor, 
			@PathVariable(name = "tipoMoeda") String tipoMoeda, 
			@PathVariable(name = "tipoOperacao") String tipoOperacao) {
		
		Moeda moeda = MoedaDataSource.get(tipoMoeda);
		
		double cotacao = 0.0;
		
		if (moeda != null) {
			if (tipoOperacao.equalsIgnoreCase("venda")) {
				if (!tipoMoeda.equalsIgnoreCase("OU")) {
					cotacao = valor / moeda.getValorVenda();
				} else {
					cotacao = valor / calcularValorVendaOuro(moeda);
				}
				
			} else {
				cotacao = valor * moeda.getValorCompra();
			}
		}
		//se a moeda for encontrada, retorna a cotacao devidamente calculada
		return cotacao;
	}
	
	private double calcularValorVendaOuro(Moeda moeda) {
		
		double valorVendaOuro = moeda.getValorCompra() + (moeda.getValorCompra() * moeda.getValorVenda() / 100);
		return valorVendaOuro;
		
	}
	
	
	@RequestMapping(value = "/cotacao_moeda", method = RequestMethod.GET)
	public List<MoedasDTO2> getListaMoedasDTO2() {
		return MoedaDataSource.getListaMoedasDTO2();
	}
	
	
	@RequestMapping(value = "/converter_moeda_dto/{valor}/{tipoOperacao}", method = RequestMethod.GET)
	public MoedasDTO moedasDTO(
			@PathVariable(name = "valor") double valor,
			@PathVariable(name = "tipoOperacao") String tipoOperacao) {

		return MoedaDataSource.converterValoresMoedas(valor, tipoOperacao);
	}
		
}
	

