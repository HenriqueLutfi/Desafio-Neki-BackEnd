package com.neki.teste.dtos;

import javax.validation.constraints.NotNull;

public class SkillDTO {
	@NotNull
	private String name;

	@NotNull
	private String version;

	@NotNull
	private String description;

	@NotNull
	private String imageUrl;

	public SkillDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillDTO(@NotNull String name, @NotNull String version, @NotNull String description,
			@NotNull String imageUrl) {
		super();
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
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

}
