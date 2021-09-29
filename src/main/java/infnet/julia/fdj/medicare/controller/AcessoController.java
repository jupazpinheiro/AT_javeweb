package infnet.julia.fdj.medicare.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ClinicoService;
import infnet.julia.fdj.medicare.model.service.LaboratorialService;
import infnet.julia.fdj.medicare.model.service.ConsultaService;
import infnet.julia.fdj.medicare.model.service.MedicoService;
import infnet.julia.fdj.medicare.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ClinicoService clinicoService;
	@Autowired
	private LaboratorialService laboratorialService;
	@Autowired
	private ConsultaService consultaService;

	@GetMapping(value = "/app")
	public String telaApp(Model model) {

		Map<String, Integer> mapaTotal = new HashMap<String, Integer>();
		mapaTotal.put("Usuários", usuarioService.obterQtde());
		mapaTotal.put("Medicos", medicoService.obterQtde());
		mapaTotal.put("Clinicos", clinicoService.obterQtde());
		mapaTotal.put("Laboratoriais", laboratorialService.obterQtde());
		mapaTotal.put("Consultas", consultaService.obterQtde());

		model.addAttribute("totalizacao", mapaTotal);
		
		return "app";
	}
	
	@GetMapping(value = "/")
	public String telaHome() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario usuario = usuarioService.validar(email, senha);

		if(usuario != null) {
			
			model.addAttribute("user", usuario);

			return "index";
		} else {
			model.addAttribute("mensagem", "Autenticação inválida para o usuário "+ email +" !!!");
			
			return "login";
		}
	}
}