package com.invext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invext.model.Cliente;
import com.invext.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/salvar")
    public Cliente salvar(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clienteService.salvar(cliente);
        } catch (Exception e) {
            throw new Exception();
        }
    }
	
	@PutMapping("/atualizar")
    public Cliente atualizar(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clienteService.atualizar(cliente);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @GetMapping("/listar")
    public List<Cliente> listar() throws Exception {
        try {
            return this.clienteService.listar();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @DeleteMapping("/deletar")
    public void excluri(@RequestBody Cliente cliente) throws Exception {
        try {
            this.clienteService.excluir(cliente);
        } catch (Exception e) {
            throw new Exception();
        }
    }


}
