package com.invext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invext.model.Atendente;
import com.invext.repository.AtendenteRepository;

@Service
public class AtendenteService {

	@Autowired
	AtendenteRepository atendenteRepository;

	public void excluir(Atendente atendente) throws Exception {
		atendenteRepository.delete(atendente);
	}

	public Atendente atualizar(Atendente atendente) throws Exception {
		return atendenteRepository.save(atendente);
	}

	public Atendente salvar(Atendente atendente) throws Exception {
		return atendenteRepository.save(atendente);
	}

	public List<Atendente> listar() throws Exception {
		return atendenteRepository.findAll();
	}

}
