package br.com.bjbraz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Account;

/**
 * 
 * @author alex.braz
 *
 */
@Repository
public interface AccountRepository  extends JpaRepository<Account, Long>{
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Account> findById(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Optional<Account> findByUserNameLike(String name);
	

}