package br.com.eltonpignatel.http;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.eltonpignatel.http.domain.response.UsuarioResponse;

public interface UsuarioWS {
	List<UsuarioResponse> listaUsuarios();
}