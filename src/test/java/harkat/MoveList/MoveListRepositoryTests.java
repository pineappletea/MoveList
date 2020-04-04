package harkat.MoveList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import harkat.MoveList.domain.Move;
import harkat.MoveList.domain.MoveRepository;


// TODO: make the test for postgres, all these tests fail
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
public class MoveListRepositoryTests {

	@Autowired
	private MoveRepository repository;

	@Test
	public void findByName() {
		// Check that repository has specified move with the correct MoveType

		List<Move> moves = repository.findByName("Triangle Choke");

		assertThat(moves).hasSize(1);
		assertThat(moves.get(0).getMovetype().getName()).isEqualTo("choke");
	}

	@Test
	public void createNewMove() {
		// Create and save a move with no parameters, check that it is saved and has a
		// generated Id
		Move move = new Move();
		repository.save(move);
		assertThat(move.getId()).isNotNull();
	}

	@Test
	public void deleteMove() {
		// delete move
		repository.deleteById((long) 13);
	}

}
