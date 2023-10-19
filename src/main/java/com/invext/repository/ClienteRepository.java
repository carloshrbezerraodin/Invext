package com.invext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invext.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByEmail(String email);
}
