package infnet.julia.fdj.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.julia.fdj.medicare.model.domain.Exame;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ExameService;

@Controller
public class ExameController {
	
	@Autowired
	private ExameService exameService;

	@GetMapping(value = "/exame/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("exames", exameService.obterLista(usuario));
		
		return "exame/lista";
	}	

	@GetMapping(value = "/exame/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Exame exame = exameService.obterPorId(id);
		
		String mensagem = null;
		try {
			exameService.excluir(id);		
			mensagem = "O exame " + exame.getDescricao() + " foi cancelado!!!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão do exame "+ exame.getDescricao();
		}
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}