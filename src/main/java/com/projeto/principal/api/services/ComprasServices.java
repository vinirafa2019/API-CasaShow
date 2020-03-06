package com.projeto.principal.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.principal.exceptions.CompraNaoEncontradaException;
import com.projeto.principal.model.ItensCompra;
import com.projeto.principal.repository.ItenscompraRep;

@Service
public class ComprasServices {

	@Autowired
	private ItenscompraRep comprarrep;
	
	
	public List<ItensCompra> listar() {
		return comprarrep.findAll();
	}
	
	public Optional<ItensCompra> buscar(Long id) {
		Optional<ItensCompra> compra = comprarrep.findById(id);

		if (compra.isEmpty()) {
			throw new CompraNaoEncontradaException("Compra de evento nao pode ser encontrada");
		}
		return compra;
	}
}
