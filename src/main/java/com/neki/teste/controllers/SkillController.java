package com.neki.teste.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.teste.dtos.SkillDTO;
import com.neki.teste.entities.Skill;
import com.neki.teste.exceptions.SkillException;
import com.neki.teste.mappers.SkillMapper;
import com.neki.teste.services.SkillService;

@RestController
@RequestMapping("/skill")
@CrossOrigin
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	SkillMapper skillMapper;
	
	@GetMapping
	public ResponseEntity<List<Skill>> findAll() {
		return new ResponseEntity<>(skillService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody SkillDTO skillDto) throws SkillException {
		Skill skill= skillMapper.SkillDtoToSkill(skillDto);
		skillService.save(skill);	
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
