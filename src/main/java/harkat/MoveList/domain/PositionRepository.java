package harkat.MoveList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends CrudRepository<Position,Long> {	
		List<Position> findByName(@Param("name") String name);
}
