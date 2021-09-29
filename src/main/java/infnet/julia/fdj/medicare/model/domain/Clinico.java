package infnet.julia.fdj.medicare.model.domain;

import javax.persistence.Entity;

import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDescricaoException;
import infnet.julia.fdj.medicare.model.exceptions.ImagemComLimitacaoException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

@Entity
public class Clinico extends Exame {
	
	private String plano;
	private boolean cobertura;
	private int tipoAcomoda;
	
	public Clinico() {
		
	}

	public Clinico(String descricao, float valor, boolean urgente) {
		super(descricao, valor, urgente);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.plano);
		sb.append(";");
		sb.append(this.cobertura ? "S" : "N");
		sb.append(";");
		sb.append(this.tipoAcomoda);

		return sb.toString();
	}

	@Override
	public float calcularValorBruto() throws ClinicoSemDescricaoException, ImagemComLimitacaoException, LaboratorioNaoPreenchidoException {
		
		if(this.tipoAcomoda <= 0) {
			throw new ClinicoSemDescricaoException("[Clinico] A medida informada está inválida: " + this.tipoAcomoda);
		}
		
		float valorPlano = 0;
		if("Unimed".equalsIgnoreCase(this.plano)) {
			valorPlano = 10;
		}
		
		float valorCobertura = 10;
		if(this.cobertura) {
			valorCobertura = 50;
		}
		
		float valorTipoAcomoda = this.tipoAcomoda * 0.05f;

		return this.getValor() + valorPlano + valorCobertura + valorTipoAcomoda;
	}

	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {		
		this.plano = plano;			
	}

	public boolean isCobertura() {
		return cobertura;
	}

	public void setCobertura(boolean cobertura) {
		this.cobertura = cobertura;
	}

	public int getTipoAcomoda() {
		return tipoAcomoda;
	}

	public void setTipoAcomoda(int tipoAcomoda) {
		this.tipoAcomoda = tipoAcomoda;
	}
}