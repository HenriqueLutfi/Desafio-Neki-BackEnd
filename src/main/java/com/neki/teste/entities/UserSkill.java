package com.neki.teste.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_seq")
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@Column(name = "knowledge_level")
	private Integer knowledgeLvl;

	@Column(name = "created_at")
	private LocalDate createdAt;

	@Column(name = "updated_at")
	private LocalDate updatedAt;

	public UserSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSkill(Integer id, User user, Skill skill, Integer knowledgeLvl, LocalDate createdAt,
			LocalDate updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.skill = skill;
		this.knowledgeLvl = knowledgeLvl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getKnowledgeLvl() {
		return knowledgeLvl;
	}

	public void setKnowledgeLvl(Integer knowledgeLvl) {
		this.knowledgeLvl = knowledgeLvl;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

}
