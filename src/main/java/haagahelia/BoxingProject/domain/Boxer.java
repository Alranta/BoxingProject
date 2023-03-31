package haagahelia.BoxingProject.domain;
	//CREATE BOXER CLASS
public class Boxer {
	//GIVE PARAMETERS FOR A BOXER
	private String firstName;
	private String lastName;
	private Integer birthYear;
	private Double weight;
	private String stance;
	private Integer roundsSparred;
	
	//GENERATE CONSTRUCTORS
	//WITHOUT PARAMETERS
	public Boxer() {
		super();
	}
	//WITH PARAMETERS
	public Boxer(String firstName, String lastName, Integer birthYear, Double weight, String stance,
			Integer roundsSparred) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.weight = weight;
		this.stance = stance;
		this.roundsSparred = roundsSparred;
	}
	//SETTERS
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public void setStance(String stance) {
		this.stance = stance;
	}
	public void setRoundsSparred(Integer roundsSparred) {
		this.roundsSparred = roundsSparred;
	}
	
	//GETTERS
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getBirthYear() {
		return birthYear;
	}
	public Double getWeight() {
		return weight;
	}
	public String getStance() {
		return stance;
	}
	public Integer getRoundsSparred() {
		return roundsSparred;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Boxer [firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear + ", weight="
				+ weight + ", stance=" + stance + ", roundsSparred=" + roundsSparred + "]";
	}
}
