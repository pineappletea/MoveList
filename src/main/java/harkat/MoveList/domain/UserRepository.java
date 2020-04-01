package harkat.MoveList.domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<MoveUser, Long> {
    MoveUser findByUsername(String username);
    
}