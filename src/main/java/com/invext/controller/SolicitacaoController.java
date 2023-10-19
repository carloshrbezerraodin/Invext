package com.invext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invext.model.Solicitacao;
import com.invext.model.dto.SolicitacaoDTO;
import com.invext.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {
	
	@Autowired

	SolicitacaoService solicitacaoService;
	
	@PostMapping("/realizar")
    public Solicitacao realizar(@RequestBody SolicitacaoDTO solicitacao) throws Exception {
        try {
            return this.solicitacaoService.realizar(solicitacao);
        } catch (Exception e) {
            throw new Exception();
        }
    }
	
	@PostMapping("/atender/:idSolicitacao/:idAtendente")
    public Solicitacao realizar(@RequestParam("idSolicitacao") Long idSolicitacao, @RequestParam("idAtendente") Long idAtendente) throws Exception {
        try {
            return this.solicitacaoService.atender(idSolicitacao, idAtendente);
        } catch (Exception e) {
			throw new Exception();
		}
    }
	
	@PostMapping("/atender-automatico/:idAtendente")
    public Solicitacao atenderAutomatico(@RequestParam("idAtendente") Long idAtendente) throws Exception {
        try {
            return this.solicitacaoService.atenderAutomatico(idAtendente);
        } catch (Exception e) {
			throw new Exception();
		}
    }

    @GetMapping("/listar")
    public List<Solicitacao> listar() throws Exception {
        try {
            return this.solicitacaoService.listar();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    

}
