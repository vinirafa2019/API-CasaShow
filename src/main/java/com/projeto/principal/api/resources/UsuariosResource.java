package com.projeto.principal.api.resources;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.principal.api.services.UsuariosServices;
import com.projeto.principal.model.Usuarios;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Usuários")
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosResource {

	@Autowired
	private UsuariosServices usuarioservices;
	
//	@Autowired
//	private UserPrincipal usuarios;
	
	@ApiOperation("Lista todos os Usuario cadastrados")
	@GetMapping
	public ResponseEntity<List<Usuarios>> listar(){	
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioservices.listar());
	}
	@ApiOperation("Busca pelo ID dos usuaros cadastrados")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity <?> buscar(@PathVariable ("id") Long id) {
		Optional<Usuarios> usuarios = usuarioservices.buscar(id);			
		
		CacheControl cacheControl = CacheControl.maxAge(20,TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(usuarios);		
	}
}
