package infnet.julia.fdj.medicare.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infnet.julia.fdj.medicare.model.domain.Laboratorial;

@Repository
public interface LaboratorialRepository extends CrudRepository<Laboratorial, Integer> {

	@Query("from Laboratorial c where c.usuario.id = :userId")
	public List<Laboratorial> obterLista(Integer userId);
}