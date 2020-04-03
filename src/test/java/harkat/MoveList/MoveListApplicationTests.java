package harkat.MoveList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import harkat.MoveList.web.MoveController;


@SpringBootTest
class MoveListApplicationTests {

	@Autowired
	private MoveController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
