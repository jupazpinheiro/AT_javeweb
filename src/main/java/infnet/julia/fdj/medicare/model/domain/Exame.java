package infnet.julia.fdj.medicare.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDescricaoException;
import infnet.julia.fdj.medicare.model.exceptions.ImagemComLimitacaoException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float valor;
	private boolean urgente;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "exames")
	private List<Consulta> consultas;
	
	public Exame() {
		
	}
	
	public Exame(String descricao, float valor, boolean urgente) {
		this.descricao = descricao;
		this.valor = valor;
		this.urgente = urgente;
	}
	
	public String obterExame()  throws ClinicoSemDescricaoException, ImagemComLimitacaoException, LaboratorioNaoPreenchidoException {

		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calcularValorBruto());
		sb.append("\r\n");
		
		return sb.toString();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.urgente ? "S" : "N");
		
		return sb.toString();
	}
	
	public abstract float calcularValorBruto() throws ClinicoSemDescricaoException, ImagemComLimitacaoException, LaboratorioNaoPreenchidoException;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isUrgente() {
		return urgente;
	}
	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}