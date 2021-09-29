package infnet.julia.fdj.medicare.model.domain;

import javax.persistence.Entity;

import infnet.julia.fdj.medicare.model.exceptions.ImagemComLimitacaoException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;
import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDescricaoException;

@Entity
public class Laboratorial extends Exame {

	private float valor;
	private boolean cobertura;
	private String area;
	private int amostra;
	
	public Laboratorial() {
	}
	
	public Laboratorial(String descricao, float valor, boolean cobertura) {
		super(descricao, valor, cobertura);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.cobertura ? "S" : "N");
		sb.append(";");
		sb.append(this.amostra);

		return sb.toString();
	}

	@Override
	public float calcularValorBruto() throws LaboratorioNaoPreenchidoException {
		if (this.valor < 0 | this.amostra < 0) {
			throw new LaboratorioNaoPreenchidoException ("Informe um valor de exames válido!");
		}
		float examesTotais = 0;
		if (!this.isCobertura()) {
			examesTotais = ((this.valor + this.amostra)+this.getValor());
		}
		return this.getValor() + examesTotais;
		}


	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isCobertura() {
		return cobertura;
	}

	public void setCobertura(boolean cobertura) {
		this.cobertura = cobertura;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public int getAmostra() {
		return amostra;
	}

	public void setAmostra(int amostra) {
		this.amostra = amostra;
	}
}