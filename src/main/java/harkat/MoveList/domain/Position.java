package harkat.MoveList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Position {
	
	@Id
	@Column
    @GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	public Long positionid;
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column
	@JsonBackReference
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
		return "Position [positionid=" + positionid + ", name=" + name + "]";
	}

	public Position(Long positionid, String name, List<Move> moves) {
		super();
		this.positionid = positionid;
		this.name = name;
		this.moves = moves;
	}

	public Position() {
		super();
	}
	public Position(String name) {
		super();
		this.name = name;
	}
	
	

}
