package br.com.bjbraz.spring;

import static br.com.bjbraz.spring.ContractRestURIConstants.CYPHER;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI_SEARCH_ACCOUNTS;
import static br.com.bjbraz.spring.ContractRestURIConstants.encode;
import static br.com.bjbraz.spring.ContractRestURIConstants.toJson;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bjbraz.dto.account.CreateAccountDTO;
import br.com.bjbraz.dto.account.SearchAccountDTO;
import br.com.bjbraz.dto.withdraw.WithDrawDTO;
import br.com.bjbraz.exception.UserNotFoundException;
import br.com.bjbraz.service.AccountService;
import br.com.bjbraz.service.TransactionService;
import br.com.bjbraz.service.UserService;


/**
 * 
 * @author alex.braz
 *
 */
@RestController
public class IndexRestController {

	private TransactionService transacaoService;
	private AccountService accountService;
	private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(IndexRestController.class);

	private static final String RETORNO_ERRO = "Invalid Values";

	@Autowired
	IndexRestController(TransactionService t, AccountService c, UserService u) {
		this.transacaoService = t;
		this.accountService = c;
		this.userService = u;
	}
	
	/**
	 * 
	 * @param create
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.CRIAR_CONTA_PF, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String createAccount(@RequestBody CreateAccountDTO create) {
		this.validateCreate(create);
		
        try {
        	
    		return createAccountBePay(create);

        } catch (Exception e) {
            return generateJson("Error " + e.getMessage());
        }
		
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.SALDO_CONTA_PF, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String getBalance(@PathVariable("account")  String sellerAccount) {
		
		try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String hash = encode(CYPHER, sellerAccount);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	String urlCompleta = URI_SEARCH_ACCOUNTS + sellerAccount+"/balance";
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>("", requestHeaders);
	    	
	    	ResponseEntity<String> response = restTemplate.exchange(urlCompleta, HttpMethod.POST, entity, String.class);
	    	
	    	String retorno = (String) response.getBody();
	    	return retorno;
	    	
	    }catch(Exception e) {
	    	log.error(e.getMessage());
            return generateJson("Error " + e.getMessage());
	    }
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.SAQUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String withDraw(@PathVariable("account")  String sellerAccount, @RequestBody WithDrawDTO withDraw) {

		//String sellerAccount = "AB03C172-4F25-9A24-8C91-7D3DA4A70EB7";
		
		try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String urlCompleta = URI_SEARCH_ACCOUNTS + sellerAccount+"/withdraw";
	    	
	    	String hash = encode(CYPHER, 
	    			withDraw.getTotalAmount()+
	    			sellerAccount+
	    			withDraw.getWithdrawInfo().getBankTransfer().getBankDestination()+
	    			withDraw.getWithdrawInfo().getBankTransfer().getBranchDestination()+
	    			withDraw.getWithdrawInfo().getBankTransfer().getAccountDestination());
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	HttpEntity<WithDrawDTO> entity = new HttpEntity<WithDrawDTO>(withDraw, requestHeaders);
	    	
	    	System.out.println(generateJson(withDraw));
	    	
	    	ResponseEntity<String> response = restTemplate.exchange(urlCompleta, HttpMethod.POST, entity, String.class);
	    	
	    	String retorno = (String) response.getBody();
	    	return retorno;
		}catch(Exception e) {
	    	log.error(e.getMessage());
		}
		
		return "Error";
		
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public String createAccountBePay(CreateAccountDTO dto) throws Exception {
	    
	    try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String valoresHash = dto.getExternalIdentifier()+dto.getClient().getTaxIdentifier().getTaxId();
	    	String hash = encode(CYPHER, valoresHash);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>(toJson(dto), requestHeaders);
	    	ResponseEntity<SearchAccountDTO> response = restTemplate.exchange(URI, HttpMethod.POST, entity, SearchAccountDTO.class);
	    	SearchAccountDTO retorno = (SearchAccountDTO) response.getBody();
	    	System.out.println(retorno.getData().getAccountStatus());
	    	System.out.println(retorno.getData().getAccountHolderId());
	    	System.out.println(retorno.getData().getAccount().getAccountId());
	    	System.out.println(response.getStatusCode());
	    	
	    	return generateJson(retorno);
	    	
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	return generateJson("Error " + e.getMessage());
	    }
	    
	}
	
	
	private void validateCreate(CreateAccountDTO create) {
		// TODO Auto-generated method stub
		
	}
	
	private void validateUser(String userId) {
		this.userService.findByUserName(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}
	
	/**
	 * Cretes a http request with 5s timeout
	 * @return
	 */
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
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

	 

}
