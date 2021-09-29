package infnet.julia.fdj.medicare.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.julia.fdj.medicare.model.domain.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

	@Query("from Medico s where s.usuario.id = :userId")
	public List<Medico> obterLista(Integer userId);
}