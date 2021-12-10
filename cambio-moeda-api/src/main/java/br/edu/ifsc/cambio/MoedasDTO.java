package br.edu.ifsc.cambio;

public class MoedasDTO {
	private double valor;
	private String operacao;
	private double DC;
	private double DP;
	private double DX;
	private double DT;
	private double EU;
	private double OU;
	
	public MoedasDTO(double valor, String operacao, double dC, double dP, double dX, double dT, double eU, double oU) {
		super();
		this.valor = valor;
		this.operacao = operacao;
		DC = dC;
		DP = dP;
		DX = dX;
		DT = dT;
		EU = eU;
		OU = oU;
	}

	public MoedasDTO() {
		super();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getDC() {
		return DC;
	}

	public void setDC(double dC) {
		DC = dC;
	}

	public double getDP() {
		return DP;
	}

	public void setDP(double dP) {
		DP = dP;
	}

	public double getDX() {
		return DX;
	}

	public void setDX(double dX) {
		DX = dX;
	}

	public double getDT() {
		return DT;
	}

	public void setDT(double dT) {
		DT = dT;
	}

	public double getEU() {
		return EU;
	}

	public void setEU(double eU) {
		EU = eU;
	}

	public double getOU() {
		return OU;
	}

	public void setOU(double oU) {
		OU = oU;
	}

}
