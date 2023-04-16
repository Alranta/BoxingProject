package haagahelia.BoxingProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//CREATE BOXER CLASS
@Entity // THIS CREATES A DATABASE TABLE
@Table(name="Boxer")
public class Boxer {
	// GIVE PARAMETERS FOR A BOXER
	@Id // THIS CREATES A PRIMARYKEY FOR THE DATABASE TABLE
	@GeneratedValue(strategy = GenerationType.AUTO) // THIS AUTOGENERATES ID
	@NotNull
	private Long id;
	@NotNull
	@Size(min=1, max=30)
	private String firstName;
	@Size(min=1, max=50)
	private String lastName;
	@NotNull
	private int birthYear;
	@NotNull
	private Double weight;
	private int bouts;

	@ManyToOne // MANY BOXERS TO ONE
	@JsonIgnore // JSONIGNORE STOPS LOOP!
	@JoinColumn(name = "stance_id") // JOINS TABLES TOGETHER!
	private Stance stance;

	// GENERATE CONSTRUCTORS
	// WITHOUT PARAMETERS
	public Boxer() {
		super();
	}

	// WITH PARAMETERS
	public Boxer(String firstName, String lastName, int birthYear, Double weight, int bouts, Stance stance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.weight = weight;
		this.bouts = bouts;
		this.stance = stance;
	}

	// SETTERS
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setBouts(int bouts) {
		this.bouts = bouts;
	}

	public void setStance(Stance stance) {
		this.stance = stance;
	}
	// GETTERS

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public Double getWeight() {
		return weight;
	}

	public int getBouts() {
		return bouts;
	}

	public Stance getStance() {
		return stance;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Boxer [boxer_Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthYear="
				+ birthYear + ", weight=" + weight + ", bouts=" + bouts;
	}

}
