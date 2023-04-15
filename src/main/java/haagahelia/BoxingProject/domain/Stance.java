package haagahelia.BoxingProject.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // MAKE A TABLE TO H2
@Table(name="Stance")
public class Stance {

	@Id // TABLE HAS ID VALUE
	@GeneratedValue(strategy = GenerationType.AUTO) // AUTO GENERATE ID
	private Long id;
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
	public void setId(Long id) {
		this.id = id;
	}

	public void setStance(String stance) {
		this.stance = stance;
	}

	public void setBoxerlist(List<Boxer> boxerlist) {
		this.boxerlist = boxerlist;
	}

	// GETTERS
	public Long getId() {
		return id;
	}

	public String getStance() {
		return stance;
	}

	public List<Boxer> getBoxerlist() {
		return boxerlist;
	}

	@Override
	public String toString() {
		return "Stance = stance_id=" + id + ", stance=" + stance;
	}

}
