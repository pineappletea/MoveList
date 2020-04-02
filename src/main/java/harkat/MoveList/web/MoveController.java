package harkat.MoveList.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Front page
	@RequestMapping(value = { "/index", "/movelist", "" }, method = RequestMethod.GET)
	public String displayMoveList(Model model) {
		model.addAttribute("moves", moverepository.findAll());
		return "movelist";
	}

	// Create new move to send to the form, along with lists of types and positions
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addmove", method = RequestMethod.GET)
	public String getNewMoveForm(Model model) {
		model.addAttribute("move", new Move());
		model.addAttribute("movetypes", movetyperepository.findAll());
		model.addAttribute("positions", positionrepository.findAll());
		return "addmove";
	}
	// TODO: FRONT

	// Receive and save new move
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addmove", method = RequestMethod.POST)
	public String saveMove(@ModelAttribute Move move) {
		moverepository.save(move);
		return "redirect:/index";
	}

	// Delete move of specified Id
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletemove/{id}", method = RequestMethod.GET)
	public String deleteMove(@PathVariable("id") Long id) {
		moverepository.deleteById(id);
		return "redirect:../index";
	}

	// GET a move to edit
	@RequestMapping(value = "/editmove/{id}", method = RequestMethod.GET)
	public String getMoveToEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("move", moverepository.findById(id));
		model.addAttribute("movetypes", movetyperepository.findAll());
		model.addAttribute("positions", positionrepository.findAll());
		return "editmove";
	}

	// Save move after edits, POST
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEditedMove(Move move) {
		moverepository.save(move);
		return "redirect:../index";
	}

	// RESTfull service methods

	// all moves
	@RequestMapping(value = "/moves", method = RequestMethod.GET)
	public @ResponseBody List<Move> listMovesRest() {
		return (List<Move>) moverepository.findAll();
	}

	// single move by id
	@RequestMapping(value = "/moves/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Move> getMoveById(@PathVariable("id") Long moveId) {
		return moverepository.findById(moveId);
	}

	// all positions
	@RequestMapping(value = "/positions", method = RequestMethod.GET)
	public @ResponseBody List<Position> listPositionsRest() {
		return (List<Position>) positionrepository.findAll();
	}

	// all types
	@RequestMapping(value = "/movetypes", method = RequestMethod.GET)
	public @ResponseBody List<MoveType> listMoveTypesRest() {
		return (List<MoveType>) movetyperepository.findAll();
	}

}
