package com.projeto.principal.exceptions;

public class CasaJaExistenteEncontradaException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 776728161429334605L;

	public CasaJaExistenteEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CasaJaExistenteEncontradaException(String mensagem,Throwable causa) {
		super(mensagem,causa);
	}

}
