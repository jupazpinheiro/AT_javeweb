package infnet.julia.fdj.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ClinicoService;

@Controller
public class ClinicoController {
	
	@Autowired
	private ClinicoService clinicoService;

	@GetMapping(value = "/clinico/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("clinicos", clinicoService.obterLista(usuario));
		
		return "clinico/lista";
	}	
	
	@GetMapping(value = "/clinico")
	public String telaCadastro() {
		return "clinico/cadastro";
	}
	
	@PostMapping(value = "/clinico/incluir")
	public String incluir(Model model, Clinico clinico, @SessionAttribute("user") Usuario usuario) {
		
		clinico.setUsuario(usuario);
		
		clinicoService.incluir(clinico);
		
		model.addAttribute("msg", "Clinico " + clinico.getDescricao() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/clinico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Clinico clinico = clinicoService.obterPorId(id);
		
		String mensagem = null;
		try {
			clinicoService.excluir(id);		
			mensagem = "O clinico " + clinico.getDescricao() + " foi removido com sucesso!!!";
		} catch (Exception e) {
			mensagem = "Foi descadastrar "+ clinico.getDescricao();
		}
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}