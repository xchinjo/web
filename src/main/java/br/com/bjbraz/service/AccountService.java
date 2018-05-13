package br.com.bjbraz.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.Account;
import br.com.bjbraz.repo.AccountRepository;

@Service
public class AccountService {
	
	
	@Autowired
	private AccountRepository contaRepo;
	
	public Account consultarPorId(Long id) {
		Optional<Account> retorno = contaRepo.findById(id);
		
		if(retorno == null)
			return null;
		
		return retorno.get();
	}
	
	public Optional<Account> findByUserNameLike(String name) {
		return contaRepo.findByUserNameLike(name);
	}
	
	@Transactional
	public Account salvar(Account c) {
		return contaRepo.save(c);
	}

}
