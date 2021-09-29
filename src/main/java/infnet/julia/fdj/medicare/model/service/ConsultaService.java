package infnet.julia.fdj.medicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.model.domain.Consulta;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Consulta> obterLista(Usuario usuario){
		return consultaRepository.obterLista(usuario.getId());
	}
	
	public List<Consulta> obterLista(){

		return (List<Consulta>) consultaRepository.findAll();
	}
		
	public void incluir(Consulta consulta) {

		consultaRepository.save(consulta);
	}
	
	public void excluir(Integer id) {
		consultaRepository.deleteById(id);
	}

	public Consulta obterPorId(Integer id) {
		return consultaRepository.findById(id).orElse(null);
	}	
	public Integer obterQtde() {
		return (int) consultaRepository.count();
	}
}