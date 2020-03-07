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
import org.springframework.web.bind.annotation.RestController;

import com.projeto.principal.api.services.ComprasServices;
import com.projeto.principal.model.ItensCompra;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/api/compras")
public class CompraResource {

	@Autowired
	private ComprasServices comprasservices;
	
	@ApiOperation("Lista todas as Compras de ingressos")
	@GetMapping
	public ResponseEntity<List<ItensCompra>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(comprasservices.listar());
	}
	
	@ApiOperation("Lista uma compra por ID")
	@GetMapping("{id}")
	public ResponseEntity<?> buscar(@PathVariable ("id") Long id) {
		Optional<ItensCompra> compra = comprasservices.buscar(id);			
		
		CacheControl cacheControl = CacheControl.maxAge(20,TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(compra);		
	}
	
	
}
