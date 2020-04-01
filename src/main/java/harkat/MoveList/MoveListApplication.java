package harkat.MoveList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
			
			MoveType takedown = new MoveType("takedown");
			movetyperepository.save(takedown);
			MoveType lock = new MoveType("lock");
			movetyperepository.save(lock);
			MoveType choke = new MoveType("choke");
			movetyperepository.save(choke);
			
			Position fullguard = new Position("full guard");
			positionrepository.save(fullguard);
			Position sidecontrol = new Position("sidecontrol");
			positionrepository.save(sidecontrol);
			Position halfguard = new Position("half guard");
			positionrepository.save(halfguard);
			Position mount = new Position("mount");
			positionrepository.save(mount);
			Position standing = new Position("standing");
			positionrepository.save(standing);
			
			// String name, String videoUrl, String description, MoveType movetype, Position position)
			Move crosscollar = new Move("Cross collar choke", "https://www.youtube.com/watch?v=5tQmr_iYzBo", "", choke, mount);
			moverepository.save(crosscollar);
			Move americana = new Move("Americana", "https://www.youtube.com/watch?v=Zhh4W24rwrw", "", lock, sidecontrol);
			moverepository.save(americana);
			Move doubleleg = new Move("Double leg takedown", "https://www.youtube.com/watch?v=wxNAEByjOoA", "", takedown, standing);
			moverepository.save(doubleleg);
			
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

			// Create users: admin/admin user/user
			MoveUser user1 = new MoveUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			MoveUser user2 = new MoveUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			log.info(user1.toString());
			urepository.save(user1);
			log.info(user2.toString());
			urepository.save(user2);
			
		};
	}

}
