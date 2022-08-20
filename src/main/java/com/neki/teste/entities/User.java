package com.neki.teste.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Integer id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "last_login_date")
	private LocalDate lastLogin;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserSkill> skills;

	public User() {
		super();
	}

	public User(Integer id, String login, String password, LocalDate lastLogin, List<UserSkill> skills) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLogin = lastLogin;
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<UserSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkill> skills) {
		this.skills = skills;
	}

}
