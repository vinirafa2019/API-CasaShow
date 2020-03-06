package com.projeto.principal.exceptions;

public class UsuarioNaoEncontradoExceptions  extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2675796780767819569L;

	public UsuarioNaoEncontradoExceptions(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoExceptions(String mensagem,Throwable causa) {
		super(mensagem,causa);
	}

}
