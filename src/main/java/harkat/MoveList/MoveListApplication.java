package harkat.MoveList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harkat.MoveList.domain.Move;
import harkat.MoveList.domain.MoveRepository;
import harkat.MoveList.domain.MoveType;
import harkat.MoveList.domain.MoveTypeRepository;
import harkat.MoveList.domain.MoveUser;
import harkat.MoveList.domain.Position;
import harkat.MoveList.domain.PositionRepository;
import harkat.MoveList.domain.UserRepository;

@SpringBootApplication
public class MoveListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoveListApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(MoveListApplication.class);

	@Bean
	public CommandLineRunner demo(UserRepository urepository, MoveRepository moverepository, PositionRepository positionrepository, 
			MoveTypeRepository movetyperepository) {
		return (args) -> {
			
			// Create test data
			
			// Types
			MoveType takedown = new MoveType("takedown");
			movetyperepository.save(takedown);
			MoveType lock = new MoveType("lock");
			movetyperepository.save(lock);
			MoveType choke = new MoveType("choke");
			movetyperepository.save(choke);
			MoveType sweep = new MoveType("sweep");
			movetyperepository.save(sweep);
			MoveType positioning = new MoveType("positioning");
			movetyperepository.save(positioning);
			
			// Positions
			Position guard = new Position("guard");
			positionrepository.save(guard);
			Position sidecontrol = new Position("sidecontrol");
			positionrepository.save(sidecontrol);
			Position halfguard = new Position("half guard");
			positionrepository.save(halfguard);
			Position mount = new Position("mount");
			positionrepository.save(mount);
			Position standing = new Position("standing");
			positionrepository.save(standing);
			
			// Moves
			// String name, String videoUrl, String description, MoveType movetype, Position position)
			Move crosscollar = new Move("Cross Collar Choke", "https://www.youtube.com/watch?v=5tQmr_iYzBo", "", choke, mount, true);
			moverepository.save(crosscollar);
			Move americana = new Move("Americana", "https://www.youtube.com/watch?v=Zhh4W24rwrw", "", lock, sidecontrol, true);
			moverepository.save(americana);
			Move doubleleg = new Move("Double Leg Takedown", "https://www.youtube.com/watch?v=wxNAEByjOoA", "", takedown, standing, true);
			moverepository.save(doubleleg);
			Move scissorsweep = new Move("The Scissor Sweep", "https://youtu.be/UBf7uF5x8GQ", "", sweep, guard, true);
			moverepository.save(scissorsweep);
			Move trianglechoke = new Move("Triangle Choke", "https://www.youtube.com/watch?v=ICiYVLNRsRU", "", choke, guard, true);
			moverepository.save(trianglechoke);
			Move armbar = new Move("Armbar from mount", "https://www.youtube.com/watch?v=5uuU0LfsZOY", "", lock, mount, true);
			moverepository.save(armbar);
			Move bridgeandroll = new Move("Bridge and Roll Escape", "https://www.youtube.com/watch?v=p6QOSXVfsiI", "", positioning, mount, false);
			moverepository.save(bridgeandroll);
			Move guardreplacement = new Move("Guard Replacement with Hip Escape", "https://youtu.be/1iZjnbCun0A", "", positioning, sidecontrol, false);
			moverepository.save(guardreplacement);
			 
			
			
			// Log all types, positions and moves
			log.info("fetch all types");
			for (MoveType type : movetyperepository.findAll() ) {
				log.info(type.toString());
			}
			log.info("fetch all positions");
			for (Position pos : positionrepository.findAll() ) {
				log.info(pos.toString());
			}
			log.info("fetch all moves");
			for (Move move: moverepository.findAll() ) {
				log.info(move.toString());
			}

			MoveUser user2 = new MoveUser("admin", "$2y$10$XPzhgZu6PPwWcmtFB3NyQOV0u1K3Enn/eTSddFe2td/dSRa2./.sm", "ADMIN");
			log.info(user2.toString());
			urepository.save(user2);
			
		};
	}

}
