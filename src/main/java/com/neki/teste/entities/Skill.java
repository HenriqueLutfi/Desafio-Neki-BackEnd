package com.neki.teste.entities;

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
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
//	@SequenceGenerator(name="pessoa_sequence", sequenceName="pes_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "version")
	private String version;

	@Column(name = "description")
	private String description;

	@Column(name = "image_url")
	private String imageUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<UserSkill> skills;

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(Integer id, String name, String version, String description, String imageUrl, List<UserSkill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<UserSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkill> skills) {
		this.skills = skills;
	}

}
