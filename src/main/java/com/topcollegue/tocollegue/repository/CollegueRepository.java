package com.topcollegue.tocollegue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcollegue.tocollegue.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {
	Optional<Collegue> findByName(String name);
}
