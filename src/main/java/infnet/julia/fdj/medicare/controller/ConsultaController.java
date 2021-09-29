package infnet.julia.fdj.medicare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import infnet.julia.fdj.medicare.model.domain.Consulta;
import infnet.julia.fdj.medicare.model.domain.Exame;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ConsultaService;
import infnet.julia.fdj.medicare.model.service.ExameService;
import infnet.julia.fdj.medicare.model.service.MedicoService;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ExameService exameService;
	
	@GetMapping(value = "/consulta")
	public String tela(Model model, @SessionAttribute("user") Usuario usuario) {
				
		model.addAttribute("medicos", medicoService.obterLista(usuario));
		
		model.addAttribute("exames", exameService.obterLista(usuario));

		return "consulta/cadastro";
	}	
	
	@GetMapping(value = "/consulta/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", consultaService.obterLista(usuario));

		return "consulta/lista";
	}

	@PostMapping(value = "/consulta/incluir")
	public String incluir(Model model, Consulta consulta, @RequestParam String[] examesId, @SessionAttribute("user") Usuario usuario) {
		
		List<Exame> exames = new ArrayList<Exame>();
		
		for(String id : examesId) {
			exames.add(exameService.obterPorId(Integer.valueOf(id)));
		}
		
		consulta.setExames(exames);

		consulta.setUsuario(usuario);
		
		consultaService.incluir(consulta);
		
		String mensagem = "A consulta "+ consulta.getDescricao() +" foi cadastrada com sucesso!!!";
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}	
	
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Consulta consulta = consultaService.obterPorId(id);
		
		consultaService.excluir(id);
		
		String mensagem = "A consulta "+ consulta.getDescricao() +" foi cancelada!!!";
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}	
}