package harkat.MoveList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long positionid;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
	private List<Move> moves;

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "Position [positionid=" + positionid + ", name=" + name + ", moves=" + moves + "]";
	}

	public Position(Long positionid, String name, List<Move> moves) {
		super();
		this.positionid = positionid;
		this.name = name;
		this.moves = moves;
	}

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}