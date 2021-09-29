package infnet.julia.fdj.medicare.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.julia.fdj.medicare.model.domain.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {

	@Query("from Consulta p where p.usuario.id = :userId")
	public List<Consulta> obterLista(Integer userId);
}