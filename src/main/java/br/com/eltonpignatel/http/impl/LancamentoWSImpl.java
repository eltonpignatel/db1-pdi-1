package br.com.eltonpignatel.http.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eltonpignatel.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.gateway.database.entity.Usuario;
import br.com.eltonpignatel.http.LancamentoWS;
import br.com.eltonpignatel.http.domain.response.LancamentoResponse;
import br.com.eltonpignatel.http.domain.response.ProcessaParcelasResponse;
import br.com.eltonpignatel.http.domain.response.UsuarioResponse;
import br.com.eltonpignatel.service.impl.LancamentoServiceImpl;

@RestController
@RequestMapping("/transactions")
public class LancamentoWSImpl implements LancamentoWS {
	
	@Autowired
	LancamentoServiceImpl lancamentoService;
	
	@GetMapping("listTransactions")  
	public List<LancamentoResponse> listaLancamentos() {
		List<LancamentoResponse> lancamentosResponse = new ArrayList<LancamentoResponse>();
		List<Lancamento> lancamentos = lancamentoService.findAll();
		
		lancamentos.stream().forEach( lancamento -> {
			lancamentosResponse.add(new LancamentoResponse(lancamento));
		});
		
		return lancamentosResponse;
	}

	@PostMapping("processTransactions")
	public ProcessaParcelasResponse processaParcelas(@RequestBody String descricao, Long usuario, Long valor, Integer numeroParcelas) {
		String retorno = lancamentoService.processaLancamentos(descricao, usuario, valor, numeroParcelas);
		ProcessaParcelasResponse processaParcelasResponse = new ProcessaParcelasResponse();
		processaParcelasResponse.setMensagem(retorno);
		return processaParcelasResponse;
	}
	
}
