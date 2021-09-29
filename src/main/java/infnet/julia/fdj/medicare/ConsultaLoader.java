package infnet.julia.fdj.medicare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Laboratorial;
import infnet.julia.fdj.medicare.model.domain.Consulta;
import infnet.julia.fdj.medicare.model.domain.Exame;
import infnet.julia.fdj.medicare.model.domain.Medico;
import infnet.julia.fdj.medicare.model.domain.Usuario;
import infnet.julia.fdj.medicare.model.service.ConsultaService;

@Component
@Order(4)
public class ConsultaLoader implements ApplicationRunner {
	
	@Autowired
	private ConsultaService consultaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Medico medico = new Medico();
		medico.setId(1);

		Clinico c1 = new Clinico();
		c1.setId(1);

		Laboratorial l1 = new Laboratorial();
		l1.setId(2);
		
		List<Exame> exames = new ArrayList<Exame>();
		exames.add(c1);
		exames.add(l1);
		
		Consulta consulta = new Consulta();
		consulta.setDescricao("Meu exame");
		consulta.setExames(exames);
		consulta.setMedico(medico);
		consulta.setUsuario(usuario);
		
		consultaService.incluir(consulta);
	}
}