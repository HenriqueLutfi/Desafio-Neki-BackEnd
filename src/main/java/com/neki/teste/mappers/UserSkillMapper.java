package com.neki.teste.mappers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neki.teste.dtos.UserSkillDTO;
import com.neki.teste.entities.Skill;
import com.neki.teste.entities.User;
import com.neki.teste.entities.UserSkill;
import com.neki.teste.exceptions.SkillException;
import com.neki.teste.exceptions.UserException;
import com.neki.teste.repositories.SkillRepository;
import com.neki.teste.repositories.UserRepository;

@Component
public class UserSkillMapper {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SkillRepository skillRepository;

	public UserSkill UserSkillDtoToUserSkill(UserSkillDTO userSkillDto) throws UserException, SkillException {
		UserSkill userSkill = new UserSkill();
		Optional<User> optionalUser = userRepository.findById(userSkillDto.getUserId());
		Optional<Skill> optionalSkill = skillRepository.findById(userSkillDto.getSkillId());

		if (optionalUser.isEmpty())
			throw new UserException("usuario nao encontrado");

		if (optionalSkill.isEmpty())
			throw new SkillException("skill nao encontrada");

//		if (userSkillDto.getId() == null) {
//			for (int i = 0; i <= optionalUser.get().getSkills().size(); i++) {
//				System.out.println(optionalUser.get().getSkills().stream().map(entity -> new Skill()).collect(Collectors.toList()));
//			}
//		}

//		System.out.println(optionalUser.get().getSkills().size());
		userSkill.setUser(optionalUser.get());
		userSkill.setSkill(optionalSkill.get());
		userSkill.setKnowledgeLvl(userSkillDto.getKnowledgeLvl());
		userSkill.setCreatedAt(LocalDate.now());
		userSkill.setUpdatedAt(LocalDate.now());
		userSkill.setId(userSkillDto.getId());
		return userSkill;
	}
}
