package br.com.eltonpignatel.gateway.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.gateway.database.entity.Lancamento;

public interface ProcessaLancamentoRepository {
	
	public String processaLancamentos();
}
