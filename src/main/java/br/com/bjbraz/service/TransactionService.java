package br.com.bjbraz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.Transaction;
import br.com.bjbraz.repo.AccountRepository;
import br.com.bjbraz.repo.TransactionRepository;

/**
 * 
 * @author asimas
 *
 */
@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transacaoRepo;
	
	@Autowired
	private AccountRepository contaRepo;

	private static final String RETORNO_ERRO_VALOR_NAO_PERMITIDO = "Value not allowed";
	private static final String RETORNO_ERRO_VALOR_NEGATIVO = "Negative value not allowed";
	private static final String RETORNO_SUCESSO = "Sucess";


	@Transactional
	public Transaction salvar(Transaction c) {
		return transacaoRepo.save(c);
	}
	
	public List<Transaction> listarTodos() {
		return transacaoRepo.findAll();
	}
	
}
