package com.invext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invext.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
	
	
	@Query(value = "SELECT * FROM solicitacao WHERE ordem IS NOT NULL ORDER BY ordem DESC LIMIT 1", nativeQuery = true)
	Solicitacao atenderPelaOrdem();

}
