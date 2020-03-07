package com.projeto.principal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.principal.model.CasaShow;

public interface CasasShowsRep extends JpaRepository<CasaShow,Long>{

	public List<CasaShow> findByNomecasa(String nomecasa);

}
