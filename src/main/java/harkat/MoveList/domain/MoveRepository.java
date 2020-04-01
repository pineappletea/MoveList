package harkat.MoveList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MoveRepository extends CrudRepository<Move,Long> {	
		List<Move> findByName(String name);
}
