package br.com.bjbraz.spring;

import java.util.List;

import org.nem.core.model.Account;
import org.nem.core.model.primitive.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bjbraz.domain.BlockchainData;
import br.com.bjbraz.domain.BlockchainNotarized;
import br.com.bjbraz.dto.account.SensorBlockchainDTO;
import br.com.bjbraz.service.BlockchainNotarizedService;
import br.com.bjbraz.service.BlockchainService;
import br.com.bjbraz.util.StringUtil;
import io.nem.apps.api.AccountApi;
import io.nem.apps.builders.ConfigurationBuilder;
import io.nem.apps.builders.TransferTransactionBuilder;

/**
 * 
 * @author alex.braz
 *
 */
@RestController
public class BlockchainRestController {

	private BlockchainService transacaoService;
	
	private BlockchainNotarizedService transacaoNotaryService;

	private static final String RETORNO_ERRO = "Invalid Values";
	
	private static final String ACCOUNT = "6dc7873ca6d3d2e7be2baa22573e9963b1ada5a54778705e286fd54499a3f6fd";
	
	private static final String SECRET_KEY = "uT439ny$5c#79m#TK32r";

	@Autowired
	BlockchainRestController(BlockchainService t, BlockchainNotarizedService tns) {
			this.transacaoService = t;
			this.transacaoNotaryService = tns;
			
			String privateKeyToAddress = new Account(
					new org.nem.core.crypto.KeyPair(org.nem.core.crypto.PrivateKey.fromHexString(ACCOUNT)))
							.getAddress().getEncoded();

			ConfigurationBuilder.nodeNetworkName("TestNet")
		    .nodeNetworkProtocol("http")
		    .nodeNetworkUri("localhost") //TESTNET NODE 50.3.87.123
		    .nodeNetworkPort("7890")
		    .setup();
			
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.REGISTRAR_ARQUIVO_BLOCKCHAIN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerFile(@RequestHeader(value="api-key") String key, @PathVariable("documentHash")  String documentHash) {
		try {
			
			if(!SECRET_KEY.equals(key)) {
				return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
			}
			
			/**
			 * 
			 */
			if(StringUtil.isBlankOrNull(documentHash)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			/**
			 * 
			 */
			List<BlockchainNotarized> items = transacaoNotaryService.searchByHash(documentHash);
			
			/**
			 * 
			 */
			if(null != items && items.size() > 0) {
				return new ResponseEntity<>("Hash Already Registered, try " + ContractRestURIConstants.BUSCAR_ARQUIVO_POR_HASH, HttpStatus.ALREADY_REPORTED);
			}
			
			ConfigurationBuilder.nodeNetworkName("TestNet")
		    .nodeNetworkProtocol("http")
		    .nodeNetworkUri("50.3.87.123") //TESTNET NODE 50.3.87.123
		    .nodeNetworkPort("7890")
		    .setup();
			
			org.nem.core.crypto.KeyPair senderPrivateKeyPair, recipientPublicKeyPair;
	
			senderPrivateKeyPair = new org.nem.core.crypto.KeyPair(
					org.nem.core.crypto.PrivateKey.fromHexString(StringUtil.sanityzer(ACCOUNT)));
			recipientPublicKeyPair = AccountApi.getAccountByAddress(StringUtil.sanityzer("TDLUE6PJPQPTYEVBOSS4GNZKW4VRM7H76DRSRGON")).getEntity()
					.getKeyPair();
			
			org.nem.core.model.ncc.NemAnnounceResult result = TransferTransactionBuilder
					.sender(new Account(senderPrivateKeyPair)).recipient(new Account(AccountApi.getAccountByAddress(StringUtil.sanityzer("TDLUE6PJPQPTYEVBOSS4GNZKW4VRM7H76DRSRGON")).getEntity().getAddress()))
					.amount(new Amount(0)).fee(Amount.fromMicroNem(500000)) // fee
					.message(documentHash, org.nem.core.model.MessageTypes.PLAIN) //IF YOU SEND A
					// MESSAGE, INCREASE THE FEE FIELD
					.buildAndSendTransaction();
	
			if(result.getCode() == 17) {
				throw new Exception(result.getMessage());
			}
			
			System.out.println(result.getCode());
			System.out.println(result.getTransactionHash());
			System.out.println(result.getMessage());
			System.out.println(result.getTransactionHash().getRaw());
			
			BlockchainNotarized entity = new BlockchainNotarized();
			entity.setBlockchainHash(result.getTransactionHash().toString());
			entity.setDocumentHash(documentHash);
			entity.setTransactionDate(StringUtil.hojeDataHoraTimestamp());
			transacaoNotaryService.salvar(entity);
			
			return ResponseEntity.ok(generateJson(entity));
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.LISTAR_TODOS_ARQUIVOS_REGISTRADOS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listAllRegisteredFiles(@RequestHeader(value="api-key") String key) {
		if(!SECRET_KEY.equals(key)) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		try {
			List<BlockchainNotarized> items = transacaoNotaryService.searhAll();
			return ResponseEntity.ok(generateJson(items));
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.BUSCAR_ARQUIVO_POR_HASH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> searchByHash(@RequestHeader(value="api-key") String key, @PathVariable("documentHash")  String documentHash) {
		if(!SECRET_KEY.equals(key)) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		try {
			
			if(StringUtil.isBlankOrNull(documentHash)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			 
			List<BlockchainNotarized> items = transacaoNotaryService.searchByHash(documentHash);
			return ResponseEntity.ok(generateJson(items));  
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * 
	 * @param dtoToJson
	 * @return
	 */
	private String generateJson(Object dtoToJson) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String json = mapper.writeValueAsString(dtoToJson);
	        return json;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
//
//	@CrossOrigin
//	@RequestMapping(value = ContractRestURIConstants.SALVAR_ESTATS_BLOCKCHAIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public String setData(
//			@RequestBody SensorBlockchainDTO create) {
//
//		return setDataGet(create);
//	}
//	
//	@CrossOrigin
//	@RequestMapping(value = ContractRestURIConstants.SALVAR_ESTATS_BLOCKCHAIN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public String setDataGet(
//			@RequestBody SensorBlockchainDTO create) {
//
//		BlockchainData retorno = transacaoService.salvar(create);
//		
//		return retorno.getTransactionHash();
//	}	

}
