package harkat.MoveList.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Move {
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column(name= "videourl", nullable = true)
	private String videoUrl;
	
	@Column(name= "description", nullable = true)
	private String description;
	
	@Column(name="inposition", nullable = true)
	private boolean inposition;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movetype")
    private MoveType movetype;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "position")
    private Position position;
	
	// to string

	@Override
	public String toString() {
		return "Move [name=" + name + ", videoUrl=" + videoUrl + ", description=" + description + ", id=" + id
				+ ", movetype=" + movetype + ", position=" + position + "]";
	}
	// default constuctor with no ID
		public Move(String name, String videoUrl, String description, MoveType movetype, 
				Position position, boolean inposition) {
			super();
			this.name = name;
			this.videoUrl = videoUrl;
			this.description = description;
			this.movetype = movetype;
			this.position = position;
			this.inposition = inposition;
		}
	
	// full constuctor
	public Move(String name, String videoUrl, String description, long id, MoveType movetype, 
			Position position, boolean inposition) {
		super();
		this.name = name;
		this.videoUrl = videoUrl;
		this.description = description;
		this.id = id;
		this.movetype = movetype;
		this.position = position;
	}
	
	// constuctor without inposition
	public Move(String name, String videoUrl, String description, long id, MoveType movetype, Position position) {
		super();
		this.name = name;
		this.videoUrl = videoUrl;
		this.description = description;
		this.id = id;
		this.movetype = movetype;
		this.position = position;
	}
	
	// constructor without ID and inposition
	public Move(String name, String videoUrl, String description, MoveType movetype, Position position) {
		super();
		this.name = name;
		this.videoUrl = videoUrl;
		this.description = description;
		this.movetype = movetype;
		this.position = position;
	}

	public Move() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MoveType getMovetype() {
		return movetype;
	}

	public void setMovetype(MoveType movetype) {
		this.movetype = movetype;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isInposition() {
		return inposition;
	}
	public void setInposition(boolean inposition) {
		this.inposition = inposition;
	}
	
    
    

}
