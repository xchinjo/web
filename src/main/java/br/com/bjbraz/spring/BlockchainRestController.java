package br.com.bjbraz.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bjbraz.domain.BlockchainData;
import br.com.bjbraz.dto.account.SensorBlockchainDTO;
import br.com.bjbraz.service.BlockchainService;

/**
 * 
 * @author alex.braz
 *
 */
@RestController
public class BlockchainRestController {

	private BlockchainService transacaoService;

	private static final String RETORNO_ERRO = "Invalid Values";

	@Autowired
	BlockchainRestController(BlockchainService t) {
			this.transacaoService = t;
	}

	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.SALVAR_ESTATS_BLOCKCHAIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setData(
			@RequestBody SensorBlockchainDTO create) {

		return setDataGet(create);
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.SALVAR_ESTATS_BLOCKCHAIN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setDataGet(
			@RequestBody SensorBlockchainDTO create) {

		BlockchainData retorno = transacaoService.salvar(create);
		
		return retorno.getTransactionHash();
	}	

}
