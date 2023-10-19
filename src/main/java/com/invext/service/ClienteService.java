package com.invext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invext.model.Cliente;
import com.invext.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void excluir(Cliente cliente) throws Exception {
		clienteRepository.delete(cliente);
	}

	public Cliente atualizar(Cliente cliente) throws Exception {
		return clienteRepository.save(cliente);
	}

	public Cliente salvar(Cliente cliente) throws Exception {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listar() throws Exception {
		return clienteRepository.findAll();
	}

}
