package com.neki.teste.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neki.teste.dtos.UserDTO;
import com.neki.teste.entities.User;
import com.neki.teste.exceptions.UserException;
import com.neki.teste.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findAtividadeById(Integer id) {
		return userRepository.findById(id).isPresent() ? userRepository.findById(id).get():null;
	}
	
//	public User save(User user) throws UserException {
//		Optional<User> optionalByLogin = userRepository.findByLogin(user.getLogin());
//		
//		if(optionalByLogin.isPresent())
//			throw new UserException("Usuario ja cadastrado");
//		
//		
//		return userRepository.save(user);
//	}
	public User save(UserDTO userDto) throws UserException {
		Optional<User> optionalByLogin = userRepository.findByLogin(userDto.getLogin());
		
		if(optionalByLogin.isPresent()) {
			throw new UserException("Usuario ja cadastrado");
		}
		User newUser = new User();
		newUser.setLogin(userDto.getLogin());
		if(!userDto.getPassword().equals("")) {
			newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		}
		newUser.setLastLogin(LocalDate.now());
		
		
		return userRepository.save(newUser);
	}
	
	public User findUserLogin(String login) {
		Optional<User> optional = userRepository.findByLogin(login);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return optional.get();
	}
	
	
}
