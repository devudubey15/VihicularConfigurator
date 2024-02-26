package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.JWTuser;

@Repository
public interface JwtRepository extends JpaRepository<JWTuser, Long> {

	JWTuser findByUsername(String username);
}
