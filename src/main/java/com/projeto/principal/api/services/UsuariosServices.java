package com.projeto.principal.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.principal.exceptions.UsuarioNaoEncontradoExceptions;
import com.projeto.principal.model.Usuarios;
import com.projeto.principal.repository.UserRepository;

@Service
public class UsuariosServices {

	
	@Autowired
	private UserRepository usuariorep;
	
	public List<Usuarios> listar() {

		
//		u.setusername(usuarios.getUsername());
//		u.setpassword(usuarios.getPassword());
		
		return usuariorep.findAll();
	}
	
	
	public Optional<Usuarios> buscar(Long id) {
		Optional<Usuarios> users = usuariorep.findById(id);

		if (users.isEmpty()) {
			throw new UsuarioNaoEncontradoExceptions("Usuario nao pode encontrado");
		}
		return users;
	}
}
