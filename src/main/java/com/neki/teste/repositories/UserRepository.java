package com.neki.teste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByLogin(String login);
}
