package harkat.MoveList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harkat.MoveList.domain.MoveUser;
import harkat.MoveList.domain.UserRepository;

@SpringBootApplication
public class MoveListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoveListApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(MoveListApplication.class);

	@Bean
	public CommandLineRunner demo(UserRepository urepository) {
		return (args) -> {

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
