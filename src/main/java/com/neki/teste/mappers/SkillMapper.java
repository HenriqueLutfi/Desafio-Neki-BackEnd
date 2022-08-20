package com.neki.teste.mappers;

import org.springframework.stereotype.Component;

import com.neki.teste.dtos.SkillDTO;
import com.neki.teste.entities.Skill;

@Component
public class SkillMapper {

	public Skill SkillDtoToSkill(SkillDTO skillDto) {
		Skill newSkill = new Skill();
		newSkill.setName(skillDto.getName());
		newSkill.setVersion(skillDto.getVersion());
		newSkill.setDescription(skillDto.getDescription());
		newSkill.setImageUrl(skillDto.getImageUrl());
		return newSkill;
	}
}
