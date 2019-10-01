package com.project.bookstore.domain;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long userId;
	@Column(name = "username", nullable = false, unique = true)
    private String username;
	@Column(name = "password", nullable = false)
    private String passwordHash;
	@Column(name = "role", nullable = false)
    private String role;
    
    
    private static String hash(String password) {
    	return BCrypt.hashpw(password, BCrypt.gensalt(11));
    }
    
    public User() { }
    
    public User(String user, String password, String role) {
		this.username = user;
		this.passwordHash = hash(password);
		this.role = role;
	}

    public String getUsername(){
        return username;
    }

    public String getPasswordHash(){
        return passwordHash;
    }
    
    public String getRole() {
		return role;
	}
    
    public Long getUserId() {
		return userId;
	}
    
    public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
    
    public void setUsername(String username) {
		this.username = username;
	}
    
    public void setRole(String role) {
		this.role = role;
	}
    
    public void setUserId(Long userId) {
		this.userId = userId;
	}

}
