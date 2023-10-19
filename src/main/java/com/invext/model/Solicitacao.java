package com.invext.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 2264871918842909031L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private TipoSolicitacao  tipoSolicitacao;
	
	@ManyToOne
    @JoinColumn(name = "atendente_id")
	private Atendente atendente;

	private String descricao;
	
	private Date data;
	
	private Integer ordem;
	
	private boolean fila;


}
