package br.com.bjbraz.test;

import static br.com.bjbraz.spring.ContractRestURIConstants.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import br.com.bjbraz.dto.account.SearchAccountDTO;

/*
 * 
 */
public class SearchTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
    private static final Logger log = LoggerFactory.getLogger(CreateAccountTest.class);
    private static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("YYYYMMDD");
	private static final String BALANCE = "/balance";
    
	
	@Test
	public void SearchAccountTest() {
		searchAllAccounts(MEDIATOR_ACCOUNT_ID);
	}
	
	
	@Test
	public void SearchAccountBallanceTest() {
		searchAccountBallance("3974074A-E03B-DA0F-BC75-E3D629D2996C");
	}	
	
	/**
	 * 
	 * @param mediatorAccountId
	 */
	private void searchAccountBallance(String mediatorAccountId) {

	    try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String hash = encode(CYPHER, mediatorAccountId);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>(null, requestHeaders);
	    	ResponseEntity<SearchAccountDTO> response = restTemplate.exchange(URI_SEARCH_ACCOUNTS+mediatorAccountId+BALANCE, HttpMethod.GET, entity, SearchAccountDTO.class);
	    	System.out.println(response.getBody());
	    	
	    	
	    	System.out.println(response.getStatusCode());
		    assertTrue(response.getStatusCodeValue() == 200);
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	fail();
	    }		
	}



	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public void searchAllAccounts(String accountToSearch) {
	    
	    try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String hash = encode(CYPHER, accountToSearch);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>(null, requestHeaders);
	    	ResponseEntity<SearchAccountDTO> response = restTemplate.exchange(URI_SEARCH_ACCOUNTS+accountToSearch, HttpMethod.GET, entity, SearchAccountDTO.class);
	    	System.out.println(response.getBody());
	    	
	    	
	    	System.out.println(response.getStatusCode());
		    assertTrue(response.getStatusCodeValue() == 200);
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	fail();
	    }
	}
	
	/**
	 * 
	 * @return
	 */
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
	
	
	public void forObject() {
		RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        String retorno = quote.toString();
        log.info(retorno); 
	}
	
	public String generateExternalIdentifier() {
		/**
		 * Formação do campo "externalIdentifier"
			O campo 'externalIdentifier' suporta até 30 dígitos e visando não ocorrer duplicidades para diferentes parceiros, pois esse número deve ser único no nosso sistema, solicitamos:
			1) Da posição 01 a 14 - Informar o CNPJ (Exemplo: 87262488000103);
			2) Da posição 15 a 22 - Usar a data no formato AAAAMMDD
			3) Da posição 22 a 30 - Usar um sequencial (que pode ou não ser reinicializado diariamente)
			
			Exemplo de formação do campo "externalIdentifier": 872624880001032017071100000001
		 */
		String cnpj = "87262488000103";
		String data = YYYYMMDD.format(new Date());
		String unique = String.valueOf(System.currentTimeMillis());
		String sequencial = unique.substring(0 ,  8);
		
		return cnpj+data+sequencial;
	}
	
}
