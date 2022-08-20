package com.neki.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.teste.entities.Skill;
import com.neki.teste.exceptions.SkillException;
import com.neki.teste.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	public List<Skill> findAll(){
		return skillRepository.findAll();
	}
	
	public Skill save(Skill skill) throws SkillException {
		Optional<Skill> optionalByName = skillRepository.findByName(skill.getName());
		
		if(optionalByName.isPresent())
			throw new SkillException("Habilidade ja cadastrada");
		
		return skillRepository.save(skill);
	}
}
