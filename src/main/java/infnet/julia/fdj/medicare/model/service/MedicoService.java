package infnet.julia.fdj.medicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.model.domain.Medico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<Medico> obterLista(Usuario usuario){
		return medicoRepository.obterLista(usuario.getId());
	}
	
	public List<Medico> obterLista(){

		return (List<Medico>) medicoRepository.findAll();
	}
		
	public void incluir(Medico medico) {

		medicoRepository.save(medico);
	}
	
	public void excluir(Integer id) {
		medicoRepository.deleteById(id);
	}

	public Medico obterPorId(Integer id) {
		return medicoRepository.findById(id).orElse(null);
	}
	public Integer obterQtde() {
		return (int) medicoRepository.count();
	}
}