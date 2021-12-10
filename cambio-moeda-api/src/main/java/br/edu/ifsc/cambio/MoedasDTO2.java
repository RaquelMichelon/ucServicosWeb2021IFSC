package br.edu.ifsc.cambio;

public class MoedasDTO2 {
	private String moeda;
	private Double compra;
	private Double venda;
	public MoedasDTO2(String moeda, Double compra, Double venda) {
		super();
		this.moeda = moeda;
		this.compra = compra;
		this.venda = venda;
	}
	
	public MoedasDTO2() {
		super();
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}
	
	

}
