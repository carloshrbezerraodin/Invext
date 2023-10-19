package com.invext.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invext.model.Atendente;
import com.invext.model.Cliente;
import com.invext.model.Solicitacao;
import com.invext.model.dto.SolicitacaoDTO;
import com.invext.repository.AtendenteRepository;
import com.invext.repository.ClienteRepository;
import com.invext.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

	@Autowired
	SolicitacaoRepository solicitacaoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	AtendenteRepository atendenteRepository;

	public Solicitacao realizar(SolicitacaoDTO solicitacaoDTO) throws Exception {

		Cliente cliente = clienteRepository.findByEmail(solicitacaoDTO.getEmailCliente());

		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setCliente(cliente);
		solicitacao.setDescricao(solicitacaoDTO.getDescricao());
		solicitacao.setData(new Date());
		solicitacao.setTipoSolicitacao(solicitacaoDTO.getTipoSolicitacao());

		Atendente atendente;

		Optional<Atendente> atendenteLivre = atendenteRepository
				.findByAtendenteLivre(solicitacaoDTO.getTipoSolicitacao().codigo()).stream().findAny();

		if (atendenteLivre.isEmpty()) {
			atendente = atendenteRepository.findByTimeSolicitacao(solicitacaoDTO.getTipoSolicitacao().codigo()).stream()
					.findAny().get();
			
			Integer quantidadeSolicitacao = atendenteRepository.quantidadeSolicitacao(atendente.getId());
			
			if (quantidadeSolicitacao >= 3) {
				solicitacao.setFila(true);
				solicitacao.setOrdem(atendenteRepository.ordemFiladeEspera());
			}

		} else {
			atendente = atendenteLivre.get();
		}

		solicitacao.setAtendente(atendente);

		return solicitacaoRepository.save(solicitacao);
	}

	public Solicitacao atender(Long idSolicitacao, Long idAtendente) throws Exception {
		Solicitacao solicitacao = solicitacaoRepository.findById(idSolicitacao).get();
		Atendente atendente = atendenteRepository.findById(idAtendente).get();

		solicitacao.setFila(false);
		solicitacao.setOrdem(null);
		solicitacao.setAtendente(atendente);

		return solicitacaoRepository.save(solicitacao);

	}
	
	public Solicitacao atenderAutomatico(Long idAtendente) throws Exception {
		
		Atendente atendente = atendenteRepository.findById(idAtendente).get();
		
		Solicitacao solicitacao = solicitacaoRepository.atenderPelaOrdem();
		
		if (solicitacao == null) {
			throw new Exception("Nao existe solicitacao na fila");
		}
		
		solicitacao.setFila(false);
		solicitacao.setOrdem(null);
		solicitacao.setAtendente(atendente);
		
		return solicitacaoRepository.save(solicitacao);

	}

	public List<Solicitacao> listar() throws Exception {
		return solicitacaoRepository.findAll();
	}

}
