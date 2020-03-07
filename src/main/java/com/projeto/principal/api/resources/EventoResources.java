package com.projeto.principal.api.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.principal.api.services.EventoServices;
import com.projeto.principal.model.Evento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "Eventos")
@RestController
@RequestMapping("/api/evento")
public class EventoResources {

	
	@Autowired
	private EventoServices eventoservice;

	@ApiOperation("Lista os Eventos cadastrados")
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity< List<Evento>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listar());
		
	}
	@ApiOperation("Salva os Eventos cadastrados")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Evento eventos) {
		eventos = eventoservice.salvar(eventos);
		
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(eventos.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation("Busca pelo ID dos Eventos cadastrados")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity <?> buscar( @PathVariable ("id") Long id) {
		Optional<Evento> livro=eventoservice.buscar(id);			
		
		CacheControl cacheControl = CacheControl.maxAge(20,TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);		
	}
	@ApiOperation("Remove pelo ID dos Eventos cadastrados")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable("id")Long id) {
		eventoservice.deletar(id);
		return ResponseEntity.noContent().build();		
	}
	@ApiOperation("Atualiza pelo ID dos Eventos cadastrados")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Evento eventos,
			@PathVariable ("id") Long id) {
		eventos.setId(id);
		eventoservice.atualizar(eventos);
		return ResponseEntity.noContent().build();
	}	
	
	@ApiOperation("Lista Eventos por nome na ordem Asc")
	@GetMapping(value="/nome/Asc")
	public ResponseEntity<List<Evento>> listarcrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarcrescente());
	}
	@ApiOperation("Lista Eventos por nome na ordem Desc")
	@GetMapping(value="/nome/des")
	public ResponseEntity<List<Evento>> listardecrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarcrescente());
	}
	
	@ApiOperation("Lista data dos Eventos por ordem Asc")
	@GetMapping(value="/data/Asc")
	public ResponseEntity<List<Evento>> listardatacrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listardatacrescente());
	}
	@ApiOperation("Lista data dos Eventos por ordem Desc")
	@GetMapping(value="/data/des")
	public ResponseEntity<List<Evento>> listardatadecrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listardatacrescente());
	}
	
	@ApiOperation("Lista preço dos Eventos por ordem Asc")
	@GetMapping(value="/preco/Asc")
	public ResponseEntity<List<Evento>> listarprecocrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarprecocrescente());
	}
	@ApiOperation("Lista preço dos Eventos por ordem Desc")
	@GetMapping(value="/preco/des")
	public ResponseEntity<List<Evento>> listarprecodecrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarprecocrescente());
	}
	@ApiOperation("Lista capacidade dos Eventos por ordem Asc")
	@GetMapping(value="/capacidade/Asc")
	public ResponseEntity<List<Evento>> listarcapacidadecrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarcapacidadecrescente());
	}
	@ApiOperation("Lista capacidade dos Eventos por ordem Desc")
	@GetMapping(value="/capacidade/des")
	public ResponseEntity<List<Evento>> listarcapacidadedecrescent(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.listarcapacidadecrescente());
	}
	
}
