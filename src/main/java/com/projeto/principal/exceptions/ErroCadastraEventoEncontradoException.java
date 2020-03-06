package com.projeto.principal.exceptions;

public class ErroCadastraEventoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 764403767638210181L;

	public ErroCadastraEventoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ErroCadastraEventoEncontradoException(String mensagem,Throwable causa) {
		super(mensagem,causa);
	}
}
