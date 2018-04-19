package com.topcollegue.tocollegue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcollegue.tocollegue.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
