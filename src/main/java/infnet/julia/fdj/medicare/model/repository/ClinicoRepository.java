package infnet.julia.fdj.medicare.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.julia.fdj.medicare.model.domain.Clinico;

@Repository
public interface ClinicoRepository extends CrudRepository<Clinico, Integer> {

	@Query("from Clinico b where b.usuario.id = :userId")
	public List<Clinico> obterLista(Integer userId);
}