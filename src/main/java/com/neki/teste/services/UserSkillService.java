package com.neki.teste.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.teste.entities.Skill;
import com.neki.teste.entities.User;
import com.neki.teste.entities.UserSkill;
import com.neki.teste.exceptions.SkillException;
import com.neki.teste.exceptions.UserException;
import com.neki.teste.exceptions.UserSkillException;
import com.neki.teste.repositories.SkillRepository;
import com.neki.teste.repositories.UserRepository;
import com.neki.teste.repositories.UserSkillRepository;

@Service
public class UserSkillService {

	@Autowired
	UserSkillRepository userSkillRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	SkillRepository skillRepository;

	public List<UserSkill> findAll() {
		return userSkillRepository.findAll();
	}

	public UserSkill save(UserSkill userSkill) throws UserSkillException {
		Optional<UserSkill> existingUserSkill = userSkillRepository.findByUserSkill(userSkill.getUser(),
				userSkill.getSkill());
		if (!existingUserSkill.isEmpty()) {
			throw new UserSkillException("skill ja cadastrada");
		}

		return userSkillRepository.save(userSkill);
	}

	public UserSkill update(UserSkill userSkill) {

		return userSkillRepository.save(userSkill);
	}

	public void delete(Integer id) {
		UserSkill userSkill = userSkillRepository.findById(id).get();
		userSkillRepository.delete(userSkill);
	}

}
