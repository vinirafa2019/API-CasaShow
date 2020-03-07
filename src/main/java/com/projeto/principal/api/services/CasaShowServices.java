package com.projeto.principal.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projeto.principal.exceptions.CasaJaExistenteEncontradaException;
import com.projeto.principal.exceptions.CasaNaoEncontradaException;
import com.projeto.principal.model.CasaShow;
import com.projeto.principal.repository.CasasShowsRep;

@Service
public class CasaShowServices {

	@Autowired
	private CasasShowsRep casaRep;

	public List<CasaShow> listar() {
		return casaRep.findAll();
	}

	public Optional<CasaShow> buscar(Long id) {
		Optional<CasaShow> casa = casaRep.findById(id);

		if (casa.isEmpty()) {
			throw new CasaNaoEncontradaException("");
		}
		return casa;
	}

	public CasaShow salvar(CasaShow casa) {
		if (casa.getId() != null) {
			Optional<CasaShow> casas = casaRep.findById(casa.getId());
			if (casas.isPresent()) {
				throw new CasaJaExistenteEncontradaException("Casa ja existe ");
			}
		}

		return casaRep.save(casa);
	}

	public void deletar(Long id) {
		try {
			casaRep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CasaNaoEncontradaException("Casa de show nao pode ser encontrada");
		}
	}

	public void atualizar(CasaShow casa) {
		verificareistencia(casa);
		casaRep.save(casa);
	}

	private void verificareistencia(CasaShow casa) {
		buscar(casa.getId());
	}

	public List<CasaShow> listarpornome(String nome) {
		nome= nome.toLowerCase();
		List<CasaShow> casa=casaRep.findByNomecasa(nome);
		return casa;
	}

	public List<CasaShow> listarcrescente() {
		return casaRep.findAll(Sort.by(Sort.Direction.ASC, "nomecasa"));
	}

	public List<CasaShow> listardecrescente() {
		return casaRep.findAll(Sort.by(Sort.Direction.DESC, "nomecasa"));
	}

}
