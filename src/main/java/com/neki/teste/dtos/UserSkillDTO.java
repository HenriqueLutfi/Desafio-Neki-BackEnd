package com.neki.teste.dtos;

import javax.validation.constraints.NotNull;

public class UserSkillDTO {

	private Integer id;

	@NotNull
	private Integer userId;

	@NotNull
	private Integer skillId;

	@NotNull
	private Integer knowledgeLvl;

	public UserSkillDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSkillDTO(Integer id, @NotNull Integer userId, @NotNull Integer skillId, @NotNull Integer knowledgeLvl) {
		super();
		this.id = id;
		this.userId = userId;
		this.skillId = skillId;
		this.knowledgeLvl = knowledgeLvl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getKnowledgeLvl() {
		return knowledgeLvl;
	}

	public void setKnowledgeLvl(Integer knowledgeLvl) {
		this.knowledgeLvl = knowledgeLvl;
	}

}
