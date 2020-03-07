package com.projeto.principal.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projeto.principal.exceptions.ErroCadastraEventoEncontradoException;
import com.projeto.principal.exceptions.EventoExistenteException;
import com.projeto.principal.exceptions.EventoNaoEncontradoException;
import com.projeto.principal.model.Evento;
import com.projeto.principal.repository.EventosRep;




@Service
public class EventoServices {
	@Autowired
	private EventosRep eventorep;


	
	public List<Evento> listar() {
		return eventorep.findAll();
	}

	public Evento salvar(Evento eventos) {

		if(eventos.getId()!=null) {
			Optional<Evento> a = eventorep.findById(eventos.getId());			
			if(a.isPresent()) {
				throw new EventoExistenteException("O Autor Ja existe");
			}
		}
		return eventorep.save(eventos);
	}
	
	public Optional<Evento> buscar(Long id) {
		Optional<Evento> Evento = eventorep.findById(id);

		if (Evento.isEmpty()) {
			throw new EventoNaoEncontradoException("Evento nao pode encontrado");
		}
		return Evento;
	}

	public void deletar(Long id) {
		try {
			eventorep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EventoNaoEncontradoException("O Evento nao pode ser encontrado");
		}
	}

	public void atualizar(Evento eventos) {
		verificareistencia(eventos);
		eventorep.save(eventos);
	}

	private void verificareistencia(Evento eventos) {
		buscar(eventos.getId());
	}
	public List<Evento> listarcrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.ASC,"descricao"));
	}
	public List<Evento> listardecrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.DESC,"descricao"));
	}
	
	public List<Evento> listardatacrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.ASC,"data"));
	}
	public List<Evento> listardatadecrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.DESC,"data"));
	}
	
	public List<Evento> listarprecocrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.ASC,"Valoringresso"));
	}
	public List<Evento> listarprecodecrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.DESC,"Valoringresso"));
	}
	
	public List<Evento> listarcapacidadecrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.ASC,"capacidade"));
	}
	public List<Evento> listarcapacidadedecrescente() {
		return eventorep.findAll(Sort.by(Sort.Direction.DESC,"capacidade"));
	}
	
	
	

}
