package haagahelia.BoxingProject.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // MAKE A TABLE TO H2
public class Stance {

	@Id // TABLE HAS ID VALUE
	@GeneratedValue(strategy = GenerationType.AUTO) // AUTO GENERATE ID
	private Long stanceid;
	private String stance;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stance") // ONE STANCE CAN HAVE MANY BOXERS
	private List<Boxer> boxerlist;

	// CONSTRUCTOR
	public Stance() {
		super();
	}

	public Stance(String stance) {
		super();
		this.stance = stance;
	}

	// SETTERS
	public void setStanceId(Long stanceid) {
		this.stanceid = stanceid;
	}

	public void setStance(String stance) {
		this.stance = stance;
	}

	public void setBoxerlist(List<Boxer> boxerlist) {
		this.boxerlist = boxerlist;
	}

	// GETTERS
	public Long getStanceId() {
		return stanceid;
	}

	public String getStance() {
		return stance;
	}

	public List<Boxer> getBoxerlist() {
		return boxerlist;
	}

	@Override
	public String toString() {
		return "Stance = stance_id=" + stanceid + ", stance=" + stance;
	}

}
