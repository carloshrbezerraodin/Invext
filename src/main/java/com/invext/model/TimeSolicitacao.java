package com.invext.model;

public enum TimeSolicitacao {
	
	PROBLEMA_CARTAO(0), CONTRATACAO_EMPRESTIMO(1), OUTROS_ASSUNTOS(2);

    private final int codigo;
    TimeSolicitacao(int n) {
        this.codigo = n;
    }

    public int codigo() {
        return codigo;
    }
}
