package br.edu.ifsc.cambio;

import java.util.ArrayList;
import java.util.List;


public class MoedaDataSource {
	private static List<Moeda> listaMoedas = new ArrayList<>(); //static para que eu possa acessar essa lista de valores de modo globalizado em todo contexto da aplicação
	
	public static void criarLista() {
		listaMoedas.add(new Moeda("Dolar Comercial", "DC", 5.6061, 5.6066));
		listaMoedas.add(new Moeda("Dolar paralelo", "DP", 5.69, 5.79));
		listaMoedas.add(new Moeda("Dolar PTAX", "DX", 5.6058, 5.6064));
		listaMoedas.add(new Moeda("Dolar turismo", "DT", 5.5430, 5.7530));
		listaMoedas.add(new Moeda("Euro", "EU", 6.5630, 6.8070));
		listaMoedas.add(new Moeda("Ouro", "OU", 346.70, 1.88));

	}
	 //método para localizar na lista a moeda que quero converter
	public static Moeda get(String sigla) {
		for (Moeda moeda : listaMoedas) {
			if (moeda.getSigla().equalsIgnoreCase(sigla)) {
				return moeda;
			}
		}
		return null;
	}
	
	public static List<Moeda> getAll() {
		return listaMoedas;
	}
	
	//método estatico que retorna uma lista de MoedasDTO2
	public static List<MoedasDTO2> getListaMoedasDTO2() {
		List<MoedasDTO2> resultado = new ArrayList<>();
		for (Moeda moeda : listaMoedas) {
			MoedasDTO2 moedasDTO2 = new MoedasDTO2(moeda.getSigla(), moeda.getValorCompra(), moeda.getValorVenda());
			resultado.add(moedasDTO2);
		}
		return resultado;
	}
	
	
	public static MoedasDTO converterValoresMoedas(double valor, String tipoOperacao) {
		
		MoedasDTO moedasDTO = null;
							
		moedasDTO = new MoedasDTO(valor, tipoOperacao, 
									cotacao(listaMoedas.get(0).getSigla(), valor, tipoOperacao),
									cotacao(listaMoedas.get(1).getSigla(), valor, tipoOperacao),
									cotacao(listaMoedas.get(2).getSigla(), valor, tipoOperacao),
									cotacao(listaMoedas.get(3).getSigla(), valor, tipoOperacao),
									cotacao(listaMoedas.get(4).getSigla(), valor, tipoOperacao),
									cotacao(listaMoedas.get(5).getSigla(), valor, tipoOperacao));

		return moedasDTO;
	}
	
	
	public static double cotacao(String tipoMoeda, double valor, String tipoOperacao) {
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
		return cotacao;
	}
	
	
	private static double calcularValorVendaOuro(Moeda moeda) {
		
		double valorVendaOuro = moeda.getValorCompra() + (moeda.getValorCompra() * moeda.getValorVenda() / 100);
		return valorVendaOuro;
		
	}

}
