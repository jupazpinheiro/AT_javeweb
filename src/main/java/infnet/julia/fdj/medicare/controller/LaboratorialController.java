package infnet.julia.fdj.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.julia.fdj.medicare.model.domain.Laboratorial;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.LaboratorialService;

@Controller
public class LaboratorialController {
	
	@Autowired
	private LaboratorialService laboratorialService;

	@GetMapping(value = "/laboratorial/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("laboratoriais", laboratorialService.obterLista(usuario));
		
		return "laboratorial/lista";
	}	
	
	@GetMapping(value = "/laboratorial")
	public String telaCadastro() {
		return "laboratorial/cadastro";
	}
	
	@PostMapping(value = "/laboratorial/incluir")
	public String incluir(Model model, Laboratorial laboratorial, @SessionAttribute("user") Usuario usuario) {
		
		laboratorial.setUsuario(usuario);
		
		laboratorialService.incluir(laboratorial);
		
		model.addAttribute("msg", "Exame " + laboratorial.getDescricao() + " de laboratorio cadastrado!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/laboratorial/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Laboratorial laboratorial = laboratorialService.obterPorId(id);
		
		String mensagem = null;
		try {
			laboratorialService.excluir(id);		
			mensagem = "O exame " + laboratorial.getDescricao() + " removido!!!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão deste exame "+ laboratorial.getDescricao();
		}
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}