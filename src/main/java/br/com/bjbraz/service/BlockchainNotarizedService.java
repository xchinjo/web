package br.com.bjbraz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.BlockchainNotarized;
import br.com.bjbraz.repo.BlockchainNotarizedRepository;

@Service
public class BlockchainNotarizedService {
	
	@Autowired
	private BlockchainNotarizedRepository transacaoRepo;

	@Transactional
	public BlockchainNotarized salvar(BlockchainNotarized c) {
		return transacaoRepo.save(c);
	}
	
	public List<BlockchainNotarized> listarTodos() {
		return transacaoRepo.findAll();
	}
	
	public List<BlockchainNotarized> searchByHash(String hash) {
		return transacaoRepo.findByDocumentHash(hash);
	}

	public List<BlockchainNotarized> searhAll() {
		return transacaoRepo.findAll();
	}

}
