package homeloan.web.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="userId")
@Table(name="login")
public class Login
{
	@Id
	@Column(name="user_id")
	String userId;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
	String role;
	
	public Login(String userId, String password, String role) {
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	
	public Login() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
}