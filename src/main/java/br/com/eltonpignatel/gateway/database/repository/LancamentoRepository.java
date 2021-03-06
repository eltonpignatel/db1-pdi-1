package br.com.eltonpignatel.gateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.gateway.database.entity.Usuario;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	List<Lancamento> findAll();
}
