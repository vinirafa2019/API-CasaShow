package com.projeto.principal.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.principal.exceptions.CasaJaExistenteEncontradaException;
import com.projeto.principal.exceptions.CasaNaoEncontradaException;
import com.projeto.principal.exceptions.CompraNaoEncontradaException;
import com.projeto.principal.exceptions.ErroCadastraEventoEncontradoException;
import com.projeto.principal.exceptions.EventoExistenteException;
import com.projeto.principal.exceptions.EventoNaoEncontradoException;
import com.projeto.principal.exceptions.UsuarioNaoEncontradoExceptions;
import com.projeto.principal.model.DetalhesErro;


@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(CasaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro>handleLivroNaoEncontradoException 
					(CasaNaoEncontradaException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa de Show nao pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	@ExceptionHandler(CasaJaExistenteEncontradaException.class)
	public ResponseEntity<DetalhesErro>handleCasaJaExistenteEncontradaException
					(CasaJaExistenteEncontradaException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa já existente");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);		
	}
	
	@ExceptionHandler(EventoExistenteException.class)
	public ResponseEntity<DetalhesErro>handleEventoEventoExistenteException
					(EventoExistenteException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Evento já existente");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);		
	}
	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro>handleEventoNaoEncontradoException
					(EventoNaoEncontradoException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Evento nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	
	@ExceptionHandler(ErroCadastraEventoEncontradoException.class)
	public ResponseEntity<DetalhesErro>handleErroCadastraEventoEncontradoException
					(ErroCadastraEventoEncontradoException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Evento nao pode ser cadastrado vazio");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro>handleDataIntegrityViolationException 
					(DataIntegrityViolationException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Requisiçao invalida");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);		
	}
	@ExceptionHandler(UsuarioNaoEncontradoExceptions.class)
	public ResponseEntity<DetalhesErro>handleUsuarioNaoEncontradoExceptions
					(UsuarioNaoEncontradoExceptions e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Usuario nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	@ExceptionHandler(CompraNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro>handleCompraNaoEncontradaException
					(CompraNaoEncontradaException e, HttpServletRequest request){

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Compra nao pode ser encontrada");
		erro.setMensagemDesenvolvedor("http://errors.soceilbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
}