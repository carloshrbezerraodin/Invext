package com.invext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invext.model.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {

	@Query(value = "SELECT a.* FROM atendente a "
			+ "LEFT JOIN solicitacao s on a.id = s.atendente_id "
			+ "WHERE 2 >= (SELECT count(a2.id) FROM atendente a2 INNER JOIN solicitacao s2 ON a2.id = s2.atendente_id WHERE a2.time_solicitacao = :tipoSolicitacao) "
			+ "AND a.time_solicitacao = :tipoSolicitacao ", nativeQuery = true)
	List<Atendente> findByAtendenteLivre(@Param("tipoSolicitacao") int tipoSolicitacao);
	
	@Query(value = "SELECT a.* FROM atendente a "
			+ "WHERE a.time_solicitacao = :tipoSolicitacao ", nativeQuery = true)
	List<Atendente> findByTimeSolicitacao(@Param("tipoSolicitacao") int tipoSolicitacao);
	
	
	@Query(value = "SELECT count(1) FROM solicitacao WHERE fila = true", nativeQuery = true)
	Integer ordemFiladeEspera();
	
	@Query(value = "SELECT count(1) FROM solicitacao WHERE atendente_id = :idAtendente", nativeQuery = true)
	Integer quantidadeSolicitacao(@Param("idAtendente") Long idAtendente);

}
