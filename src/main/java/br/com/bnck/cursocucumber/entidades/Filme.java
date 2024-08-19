package br.com.bnck.cursocucumber.entidades;

public class Filme {
	private Integer estoque;
	private double aluguel;

	public void setEstoque(Integer arg1) {
		this.estoque = arg1;
	}

	public void setAluguel(Double arg1) {
		this.aluguel = arg1;
	}

	public double getAluguel() {
		return aluguel;
	}

	public Integer getEstoque() {
		return estoque;
	}

}
