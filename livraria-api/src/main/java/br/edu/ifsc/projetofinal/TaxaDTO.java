package br.edu.ifsc.projetofinal;

public class TaxaDTO {
	private int id;
	private int taxa;
	
	
	public TaxaDTO(int id, int taxa) {
		super();
		this.id = id;
		this.taxa = taxa;
	}


	public TaxaDTO() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTaxa() {
		return taxa;
	}


	public void setTaxa(int taxa) {
		this.taxa = taxa;
	}
	
	
	
	
}
