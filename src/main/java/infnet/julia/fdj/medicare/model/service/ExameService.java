package infnet.julia.fdj.medicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.model.domain.Exame;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;

	public List<Exame> obterLista(Usuario usuario){
		return (List<Exame>) exameRepository.obterLista(usuario.getId());
	}
	public List<Exame> obterLista(){
		return (List<Exame>) exameRepository.findAll();
	}

	public void excluir(Integer id) {
		exameRepository.deleteById(id);
	}
	
	public Exame obterPorId(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}
}