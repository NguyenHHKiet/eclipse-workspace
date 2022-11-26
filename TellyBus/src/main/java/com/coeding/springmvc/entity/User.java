package com.coeding.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 995257156684859067L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="username")
	private String username;
	
	@NotBlank()
	@Size(min=8, max=15, groups={FormValidationGroup.class})
	private String password;

	private String email;
	
	private boolean enabled = false;
	private String authority;
	
	
	public User() {
		
	}
	

	public User(String username, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", authority=" + authority + "]";
	}


	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	


	
	

}
