package com.neki.teste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.teste.dtos.UserSkillDTO;
import com.neki.teste.entities.UserSkill;
import com.neki.teste.exceptions.SkillException;
import com.neki.teste.exceptions.UserException;
import com.neki.teste.exceptions.UserSkillException;
import com.neki.teste.mappers.UserSkillMapper;
import com.neki.teste.services.UserSkillService;

@RestController
@RequestMapping("/userSkill")
@CrossOrigin
public class UserSkillController {
	@Autowired
	UserSkillService userSkillService;

	@Autowired
	UserSkillMapper userSkillMapper;

	@GetMapping
	public ResponseEntity<List<UserSkill>> findAll() {
		return new ResponseEntity<>(userSkillService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserSkill> save(@Valid @RequestBody UserSkillDTO userSkillDto)
			throws UserException, SkillException, UserSkillException {
		UserSkill userSkill = userSkillMapper.UserSkillDtoToUserSkill(userSkillDto);
//		userSkillService.save(userSkill);
		return new ResponseEntity<>(userSkillService.save(userSkill),HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UserSkill> update(@RequestBody UserSkillDTO userSkillDto) throws UserException, SkillException {
		UserSkill userSkill = userSkillMapper.UserSkillDtoToUserSkill(userSkillDto);
		return new ResponseEntity<>(userSkillService.update(userSkill), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Integer Id) {
		userSkillService.delete(Id);
	}
}
