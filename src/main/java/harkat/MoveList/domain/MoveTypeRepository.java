package harkat.MoveList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MoveTypeRepository extends CrudRepository<MoveType,Long> {	
		List<MoveType> findByName(String name);
}
