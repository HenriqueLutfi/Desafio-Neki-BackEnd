package com.neki.teste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.teste.dtos.UserDTO;
import com.neki.teste.entities.User;
import com.neki.teste.exceptions.UserException;
//import com.neki.teste.mappers.UserMapper;
import com.neki.teste.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	UserMapper userMapper;
	
//	public ResponseEntity<User> findUserById(@PathVariable Integer id){
//		
//	}
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) throws UserException {
		User user = userService.findAtividadeById(id);
		if(null == user)
			throw new UserException("usuario nao existe");
		else
			return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody UserDTO userDto) throws UserException {
//		User user= userMapper.UserDtoToUser(userDto);
//		userService.save(user);	
		userService.save(userDto);	
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
