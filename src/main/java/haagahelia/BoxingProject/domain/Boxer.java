package haagahelia.BoxingProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//CREATE BOXER CLASS
@Entity // THIS CREATES A DATABASE TABLE
public class Boxer {
	//GIVE PARAMETERS FOR A BOXER
	@Id // THIS CREATES A PRIMARYKEY FOR THE DATABASE TABLE
	@GeneratedValue(strategy = GenerationType.AUTO) // THIS AUTOGENERATES ID
	
	private Long boxer_Id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private Double weight;
	private String stance;
	private int bouts;
	
	//GENERATE CONSTRUCTORS
	//WITHOUT PARAMETERS
	public Boxer() {
		super();
	}
	//WITH PARAMETERS
	public Boxer(String firstName, String lastName, int birthYear, Double weight, String stance,
			int bouts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.weight = weight;
		this.stance = stance;
		this.bouts = bouts;
	}
	//SETTERS
		
	public void setBoxer_Id(Long boxer_Id) {
		this.boxer_Id = boxer_Id;
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
	public void setStance(String stance) {
		this.stance = stance;
	}
	public void setBouts(int bouts) {
		this.bouts = bouts;
	}
		
	//GETTERS
		
	public Long getBoxer_Id() {
		return boxer_Id;
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
	public String getStance() {
		return stance;
	}
	public int getBouts() {
		return bouts;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Boxer [firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear + ", weight="
				+ weight + ", stance=" + stance + ", Bouts" + bouts + "]";
	}
}
