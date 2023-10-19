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

import com.invext.model.Atendente;
import com.invext.service.AtendenteService;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {
	
	@Autowired
	AtendenteService atendenteService;
	
	@PostMapping("/salvar")
    public Atendente salvar(@RequestBody Atendente atendente) throws Exception {
        try {
            return this.atendenteService.salvar(atendente);
        } catch (Exception e) {
            throw new Exception();
        }
    }
	
	@PutMapping("/atualizar")
    public Atendente atualizar(@RequestBody Atendente atendente) throws Exception {
        try {
            return this.atendenteService.atualizar(atendente);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @GetMapping("/listar")
    public List<Atendente> listar() throws Exception {
        try {
            return this.atendenteService.listar();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @DeleteMapping("/deletar")
    public void excluri(@RequestBody Atendente atendente) throws Exception {
        try {
            this.atendenteService.excluir(atendente);
        } catch (Exception e) {
            throw new Exception();
        }
    }


}
