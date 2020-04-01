package harkat.MoveList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harkat.MoveList.domain.MoveRepository;
import harkat.MoveList.domain.MoveTypeRepository;
import harkat.MoveList.domain.PositionRepository;

@Controller
public class MoveController {
	@Autowired
	private MoveRepository moverepository;
	@Autowired
	private MoveTypeRepository movetyperepository;
	@Autowired
	private PositionRepository positionrepository;
	
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"/index", "/movelist"}, method = RequestMethod.GET)
	public String displayMoveList(Model model) {
		model.addAttribute("moves", moverepository.findAll());
		return "movelist";
	}
	
	

}
