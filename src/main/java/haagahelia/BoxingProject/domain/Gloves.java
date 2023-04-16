package haagahelia.BoxingProject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //CREATE TABLE
@Table(name="gloves") // CREATE NAME FOR THE TABLE
public class Gloves {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	private String name;
	private int weight;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gloves") // ONE GLOVES CAN HAVE MANY BOXERS
	private List<Boxer> boxerlist;
	
	public Gloves() {
		super();
	}

	public Gloves(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public Gloves(String name) {
		super();
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Gloves [id=" + id + ", name=" + name + ", weight=" + weight + "Oz" + "]";
	}
	
	
	
}
