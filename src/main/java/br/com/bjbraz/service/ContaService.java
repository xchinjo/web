package br.com.bjbraz.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.Conta;
import br.com.bjbraz.repo.ContaRepository;

@Service
public class ContaService {
	
	
	@Autowired
	private ContaRepository contaRepo;
	
	public Conta consultarPorId(Long id) {
		Optional<Conta> retorno = contaRepo.findById(id);
		
		if(retorno == null)
			return null;
		
		return retorno.get();
	}
	
	@Transactional
	public Conta salvar(Conta c) {
		return contaRepo.save(c);
	}

}
