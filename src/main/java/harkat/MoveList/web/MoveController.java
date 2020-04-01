package harkat.MoveList.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoveController {
	
	
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}

}
