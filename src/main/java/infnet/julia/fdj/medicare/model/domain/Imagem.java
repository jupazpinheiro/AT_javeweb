package infnet.julia.fdj.medicare.model.domain;

import infnet.julia.fdj.medicare.model.exceptions.ImagemComLimitacaoException;

public class Imagem extends Exame {

	private boolean preparacao;
	private String limitacao;
	private int area;
	
	public Imagem(String descricao, float valor, boolean urgente) {
		super(descricao, valor, urgente);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.preparacao ? "S" : "N");
		sb.append(";");
		sb.append(this.limitacao);
		sb.append(";");
		sb.append(this.area);

		return sb.toString();
	}

	@Override
	public float calcularValorBruto() throws ImagemComLimitacaoException {

		if(this.limitacao.isBlank()) {
			throw new ImagemComLimitacaoException("[Imagem] Nenhuma limitação adicionado!");
		}
		
		float valorIndividual = 0;
		if(this.preparacao) {
			valorIndividual = 20;
		}

		float valorAcompanhamento = this.limitacao.split(",").length * 2;

		float valorTamanho = this.area * 2f;
		
		return this.getValor() + valorIndividual + valorAcompanhamento + valorTamanho;
	}

	public boolean isPreparacao() {
		return preparacao;
	}

	public void setPreparacao(boolean preparacao) {
		this.preparacao = preparacao;
	}

	public String getLimitacao() {
		return limitacao;
	}

	public void setLimitacao(String limitacao) {
		this.limitacao = limitacao;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
}
