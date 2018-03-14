package br.com.bjbraz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Conta;

/**
 * 
 * @author alex.braz
 *
 */
@Repository
public interface ContaRepository  extends JpaRepository<Conta, Long>{
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Conta> findById(Long id);
	
	

}