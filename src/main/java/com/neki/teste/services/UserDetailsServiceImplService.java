package com.neki.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neki.teste.entities.User;
import com.neki.teste.exceptions.UserException;
import com.neki.teste.repositories.UserRepository;
import com.neki.teste.security.UserSS;

@Service
public class UserDetailsServiceImplService implements UserDetailsService {
//	@Autowired
//	UserService userService;
	@Autowired
	UserRepository userService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userService.findUserLogin(username);
		Optional<User> user = userService.findByLogin(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("alalala");
		}
//		System.out.println(user.get().getLogin());
//		System.out.println(user.get().getPassword());

		return new UserSS(user.get());
	}
}
