package infnet.julia.fdj.medicare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Laboratorial;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ClinicoService;
import infnet.julia.fdj.medicare.model.service.LaboratorialService;

@Component
@Order(3)
public class ExameLoader implements ApplicationRunner {
	
	@Autowired
	private ClinicoService clinicoService;
	@Autowired
	private LaboratorialService laboratorialService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Clinico c1 = new Clinico("Emergencia", 10, true);
		c1.setCobertura(true);
		c1.setPlano("Unimed");
		c1.setTipoAcomoda(500);
		c1.setUsuario(usuario);
		
		
		clinicoService.incluir(c1);

		Laboratorial l1 = new Laboratorial("Hematologia", 5, false);
		l1.setArea("Torax");
		l1.setAmostra(1);
		l1.setCobertura(true);
		l1.setUsuario(usuario);
		
		laboratorialService.incluir(l1);
	}
}