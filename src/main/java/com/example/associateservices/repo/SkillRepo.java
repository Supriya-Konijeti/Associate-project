package com.example.associateservices.repo;


import com.example.associateservices.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skills,Integer> {
}
