package br.com.bjbraz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.BlockchainData;

@Repository
public interface BlockchainRepository extends JpaRepository<BlockchainData, Long>{
	

}
