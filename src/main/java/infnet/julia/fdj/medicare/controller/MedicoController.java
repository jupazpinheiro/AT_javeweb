package infnet.julia.fdj.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.julia.fdj.medicare.model.domain.Medico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.MedicoService;

@Controller
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@GetMapping(value = "/medico")
	public String tela() {
		return "medico/cadastro";
	}	
	
	@GetMapping(value = "/medico/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", medicoService.obterLista(usuario));

		return "medico/lista";
	}

	@PostMapping(value = "/medico/incluir")
	public String incluir(Model model, Medico medico, @SessionAttribute("user") Usuario usuario) {

		medico.setUsuario(usuario);
		
		medicoService.incluir(medico);
		
		String mensagem = "O médico "+ medico.getNome() +" cadastrado!!!";
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}	
	
	@GetMapping(value = "/medico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Medico medico = medicoService.obterPorId(id);
		
		String mensagem = null;
		try {
			medicoService.excluir(id);		
			mensagem = "O médico "+ medico.getNome() +" foi descadastrado!!!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão do médico "+ medico.getNome();
		}
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}
}