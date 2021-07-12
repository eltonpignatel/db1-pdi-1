package br.com.eltonpignatel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.eltonpignatel.gateway.database.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
}
