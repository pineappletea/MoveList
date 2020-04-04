package harkat.MoveList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoveRepository extends CrudRepository<Move,Long> {	
		List<Move> findByName(@Param("name") String name);
}
