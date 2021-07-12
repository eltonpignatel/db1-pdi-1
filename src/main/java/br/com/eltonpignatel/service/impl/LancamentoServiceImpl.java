package br.com.eltonpignatel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eltonpignatel.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.gateway.database.repository.LancamentoRepository;
import br.com.eltonpignatel.gateway.database.repository.ProcessaLancamentoRepository;
import br.com.eltonpignatel.service.LancamentosService;

@Service
public class LancamentoServiceImpl implements LancamentosService{
	
	@Autowired
	ProcessaLancamentoRepository processaLancamentoRepository;
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	
	@Override
	public List<Lancamento> findAll() {
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos = lancamentoRepository.findAll();
		return lancamentos;
	}

	@Override
	public String processaLancamentos(String descricao, Long Usuario, Long valor, Integer numeroParcelas) {
		String retorno  = processaLancamentoRepository.processaLancamentos();
		return retorno;
	}

}
