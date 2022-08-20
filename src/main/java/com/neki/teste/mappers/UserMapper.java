//package com.neki.teste.mappers;
//
//import java.time.LocalDate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.neki.teste.dtos.UserDTO;
//import com.neki.teste.entities.User;
//
//@Component
//public class UserMapper {
//	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	public User UserDtoToUser(UserDTO userDto) {
//		User newUser = new User();
//		newUser.setLogin(userDto.getLogin());
//		if(!userDto.getPassword().equals("")) {
//			newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//		}
//		newUser.setLastLogin(LocalDate.now());
//		
//		return newUser;
//	}
//}
