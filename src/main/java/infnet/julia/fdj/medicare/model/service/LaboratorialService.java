package infnet.julia.fdj.medicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.model.domain.Laboratorial;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.repository.LaboratorialRepository;

@Service
public class LaboratorialService {
	
	@Autowired
	private LaboratorialRepository laboratorialRepository;

	public List<Laboratorial> obterLista(Usuario usuario){
		return (List<Laboratorial>) laboratorialRepository.obterLista(usuario.getId());
	}
	public List<Laboratorial> obterLista(){
		return (List<Laboratorial>) laboratorialRepository.findAll();
	}
	
	public void incluir(Laboratorial laboratorial) {
		laboratorialRepository.save(laboratorial);
	}
	
	public void excluir(Integer id) {
		laboratorialRepository.deleteById(id);
	}
	
	public Laboratorial obterPorId(Integer id) {
		return laboratorialRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) laboratorialRepository.count();
	}
}