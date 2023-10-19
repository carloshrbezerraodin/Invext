package com.invext.model.dto;

import java.io.Serializable;

import com.invext.model.TipoSolicitacao;

import lombok.Data;

@Data
public class SolicitacaoDTO implements Serializable {

	private static final long serialVersionUID = 2264871918842909031L;
	
	private String emailCliente;
	private TipoSolicitacao  tipoSolicitacao;
	private String descricao;

}
