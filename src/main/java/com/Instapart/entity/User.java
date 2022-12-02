package com.Instapart.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@Column(name="email",unique = true)
	String email;
	
	@Column(name="username",unique = true)
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="phoneNumber")
	Double phoneNumber;
	
	@OneToMany
	@JoinColumn(name="user_id", referencedColumnName = "id")
	List<Part> parts;
	
	

	
	
	@OneToMany
	@JoinColumn(name="user_id", referencedColumnName = "id")
	List<Post> posts;
	
	@ManyToMany
	@JoinTable(name = "contacts",
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "contact_id"))
	List<User> contacts;
	
	
	
	
	


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<User> getContacts() {
		return contacts;
	}

	public void setContacts(List<User> contacts) {
		this.contacts = contacts;
	}

	

	public User(Integer id, String email, String username, Double phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", parts=" + parts +  ", posts=" + posts
				+ ", contacts=" + contacts + "]";
	}

	

	
	
	  
	
	
	
	
	

}
