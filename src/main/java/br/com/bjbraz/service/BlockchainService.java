package br.com.bjbraz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.BlockchainData;
import br.com.bjbraz.dto.account.SensorBlockchainDTO;
import br.com.bjbraz.repo.BlockchainRepository;
import br.com.bjbraz.util.StringUtil;

/**
 * 
 * @author asimas
 *
 */
@Service
public class BlockchainService {
	
	@Autowired
	private BlockchainRepository transacaoRepo;
	
	private static final String RETORNO_ERRO_VALOR_NAO_PERMITIDO = "Value not allowed";
	private static final String RETORNO_ERRO_VALOR_NEGATIVO = "Negative value not allowed";
	private static final String RETORNO_SUCESSO = "Success";


	@Transactional
	public BlockchainData salvar(BlockchainData c) {
		return transacaoRepo.save(c);
	}
	
	public List<BlockchainData> listarTodos() {
		return transacaoRepo.findAll();
	}

	@Transactional
	public BlockchainData salvar(SensorBlockchainDTO create) {
		BlockchainData data = new BlockchainData();
		
		try {
			data.setDateSensor(create.getData());
			data.setHourSensor(create.getHora());
			data.setHumidity(create.getHumidity());
			data.setTemperature(create.getTemperature());
			data.setTransactionDate(StringUtil.hojeDataHoraTimestamp());
			data.setTransactionHash(RETORNO_SUCESSO);
			this.salvar(data);
		}catch(Exception e) {
			data.setTransactionHash(RETORNO_ERRO_VALOR_NAO_PERMITIDO);
		}
		return data;
	}
	
}
