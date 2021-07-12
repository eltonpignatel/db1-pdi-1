package br.com.eltonpignatel.service;

import java.util.List;

import br.com.eltonpignatel.gateway.database.entity.Lancamento;

public interface LancamentosService {
	List<Lancamento> findAll();
	String processaLancamentos(String descricao, Long Usuario, Long valor, Integer numeroParcelas);
}
