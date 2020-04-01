package harkat.MoveList.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@Column(name = "username", nullable = false, unique = true)
    private String username;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@Column(name = "role", nullable = false)
    private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	

}