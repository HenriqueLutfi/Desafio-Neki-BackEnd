package com.neki.teste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neki.teste.entities.Skill;
import com.neki.teste.entities.User;
import com.neki.teste.entities.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>  {

	@Query("SELECT us FROM UserSkill us WHERE us.user = ?1 AND us.skill = ?2")
    Optional<UserSkill> findByUserSkill(User user, Skill skill);
}
