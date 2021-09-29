package infnet.julia.fdj.medicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.repository.ClinicoRepository;

@Service
public class ClinicoService {
	
	@Autowired
	private ClinicoRepository clinicoRepository;

	public List<Clinico> obterLista(Usuario usuario){
		return (List<Clinico>) clinicoRepository.obterLista(usuario.getId());
	}
	public List<Clinico> obterLista(){
		return (List<Clinico>) clinicoRepository.findAll();
	}
	
	public void incluir(Clinico clinico) {
		clinicoRepository.save(clinico);
	}
	
	public void excluir(Integer id) {
		clinicoRepository.deleteById(id);
	}
	
	public Clinico obterPorId(Integer id) {
		return clinicoRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) clinicoRepository.count();
	}
}