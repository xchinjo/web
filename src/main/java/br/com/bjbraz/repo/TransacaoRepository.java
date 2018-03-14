package br.com.bjbraz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Transacao;

@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao, Long>{
	

}
