package com.neki.teste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.teste.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>  {
	Optional<Skill> findByName(String name);
}
