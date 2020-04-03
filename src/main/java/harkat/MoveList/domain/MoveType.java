package harkat.MoveList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MoveType {
	
	@Id
    @Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long movetypeid;
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movetype")
	private List<Move> moves;

	public Long getMovetypeid() {
		return movetypeid;
	}

	public void setMovetypeid(Long movetypeid) {
		this.movetypeid = movetypeid;
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
		return "MoveType [movetypeid=" + movetypeid + ", name=" + name + "]";
	}

	public MoveType(Long movetypeid, String name, List<Move> moves) {
		super();
		this.movetypeid = movetypeid;
		this.name = name;
		this.moves = moves;
	}

	public MoveType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MoveType(String name) {
		super();
		this.name = name;
	}

	
}
