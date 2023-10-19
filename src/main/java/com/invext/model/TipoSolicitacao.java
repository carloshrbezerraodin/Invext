package com.invext.model;

public enum TipoSolicitacao {
	
	PROBLEMA_CARTAO(0), CONTRATACAO_EMPRESTIMO(1), OUTROS_ASSUNTOS(2);

    private final int codigo;
    TipoSolicitacao(int n) {
        this.codigo = n;
    }

    public int codigo() {
        return codigo;
    }
}
