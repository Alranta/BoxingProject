package haagahelia.BoxingProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users") // CREATES A USER TABLE
public class User {

	@Id // CREATES ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CREATES AUTOVALUE FOR ID

	@Column(name = "id", nullable = false, updatable = false) // COLUMN USED TO GIVE ATTRIBUTES
	private Long id;
	
	@Column(name = "username", nullable = false, updatable = false, unique = true)
	private String username;
	
	@Column(name = "passwordhash", nullable = false, updatable = false, unique = true)
	private String passwordHash;
	
	@Column(name = "role", nullable = false, updatable = false, unique = true)
	private String role;

	public User() {
		super();
	}
	//WITHOUT ID BECAUSE IT IS AUTOVALUE
	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}
	// SETTERS AND GETTERS
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public String getRole() {
		return role;
	}
	// TOSTRING
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role + "]";
	}
	
	
	
	
}
