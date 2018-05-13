package br.com.bjbraz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Parameter;

/**
 * 
 * @author asimas
 *
 */
@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long>{
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Parameter> findById(Long id);

}
