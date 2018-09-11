package br.com.bjbraz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.BlockchainNotarized;

@Repository
public interface BlockchainNotarizedRepository extends JpaRepository<BlockchainNotarized, Long>{
	
	public List<BlockchainNotarized> findByDocumentHash(String hash);
	

}
