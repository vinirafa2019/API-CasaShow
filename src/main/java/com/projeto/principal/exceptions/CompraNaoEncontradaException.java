package com.projeto.principal.exceptions;

public class CompraNaoEncontradaException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -346390440927129286L;

	public CompraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CompraNaoEncontradaException(String mensagem,Throwable causa) {
		super(mensagem,causa);
	}
}
