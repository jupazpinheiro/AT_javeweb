package infnet.julia.fdj.medicare.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.julia.fdj.medicare.model.domain.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer> {

	@Query("from Exame p where p.usuario.id = :userId")
	public List<Exame> obterLista(Integer userId);
}