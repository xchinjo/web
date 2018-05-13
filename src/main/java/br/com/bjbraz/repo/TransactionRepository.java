package br.com.bjbraz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	

}
