package infnet.julia.fdj.medicare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import infnet.julia.fdj.medicare.model.domain.Medico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.MedicoService;

@Component
@Order(2)
public class MedicoLoader implements ApplicationRunner {

	@Autowired
	private MedicoService medicoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Medico medico = new Medico("Pedro", "pe@pe.com", 71);
		medico.setUsuario(usuario);
		
		medicoService.incluir(medico);
	}
}