package com.SocialMediaBackEnd.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "_user")
public class User {

	private Long id;
	private String username;
	private String name;
	private String lastName;
//	private String email;
	private String password;
	private List<Message> message = new ArrayList<Message>();
	private List<Channel> channel = new ArrayList<Channel>();
	private Set<Authority> authority = new HashSet<>();
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique = true, nullable = false)@JsonIgnore
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable = false)@JsonIgnore
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(nullable = false)@JsonIgnore
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy = "user")@JsonIgnore
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	@ManyToMany @JsonIgnore
	public List<Channel> getChannel() {
		return channel;
	}
	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}
	@OneToMany(mappedBy = "user") @JsonIgnore
	public Set<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	
}
