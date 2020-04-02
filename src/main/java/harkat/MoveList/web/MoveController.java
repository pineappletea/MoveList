package harkat.MoveList.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import harkat.MoveList.domain.Move;
import harkat.MoveList.domain.MoveRepository;
import harkat.MoveList.domain.MoveType;
import harkat.MoveList.domain.MoveTypeRepository;
import harkat.MoveList.domain.Position;
import harkat.MoveList.domain.PositionRepository;

@Controller
public class MoveController {
	@Autowired
	MoveRepository moverepository;
	@Autowired
	MoveTypeRepository movetyperepository;
	@Autowired
	PositionRepository positionrepository;
	
	// Login page
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}
	// Front page
	@RequestMapping(value = {"/index", "/movelist"}, method = RequestMethod.GET)
	public String displayMoveList(Model model) {
		model.addAttribute("moves", moverepository.findAll());
		return "movelist";
	}

	// RESTfull service methods

	// all moves
	@RequestMapping(value="/moves", method  = RequestMethod.GET) 
	public @ResponseBody List<Move> listMovesRest(){
		return (List<Move>) moverepository.findAll();
	}
	
	// single move by id
	@RequestMapping(value="/moves/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Move> getMoveById(@PathVariable("id") Long moveId) {	
		return moverepository.findById(moveId);
	}
	
	// all positions
	@RequestMapping(value="/positions", method  = RequestMethod.GET) 
	public @ResponseBody List<Position> listPositionsRest(){
		return (List<Position>) positionrepository.findAll();
	}

	// all types
	@RequestMapping(value="/movetypes", method  = RequestMethod.GET) 
	public @ResponseBody List<MoveType> listMoveTypesRest(){
		return (List<MoveType>) movetyperepository.findAll();
	}






}
