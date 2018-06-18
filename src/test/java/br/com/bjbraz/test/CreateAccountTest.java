package br.com.bjbraz.test;

import static br.com.bjbraz.spring.ContractRestURIConstants.CPF;
import static br.com.bjbraz.spring.ContractRestURIConstants.CYPHER;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI_SEARCH_ACCOUNTS;
import static br.com.bjbraz.spring.ContractRestURIConstants.encode;
import static br.com.bjbraz.spring.ContractRestURIConstants.generateExternalIdentifier;
import static br.com.bjbraz.spring.ContractRestURIConstants.toJson;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bjbraz.dto.account.AdditionalDetailsPersonDTO;
import br.com.bjbraz.dto.account.BillingAddressDTO;
import br.com.bjbraz.dto.account.ClientDTO;
import br.com.bjbraz.dto.account.CreateAccountDTO;
import br.com.bjbraz.dto.account.MobilePhoneDTO;
import br.com.bjbraz.dto.account.RgDTO;
import br.com.bjbraz.dto.account.SearchAccountDTO;
import br.com.bjbraz.dto.account.TaxIdentifierDTO;
import br.com.bjbraz.dto.withdraw.BankTransferDTO;
import br.com.bjbraz.dto.withdraw.WithDrawDTO;
import br.com.bjbraz.dto.withdraw.WithdrawInfoDTO;

public class CreateAccountTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
    private static final Logger log = LoggerFactory.getLogger(CreateAccountTest.class);
	
	@Test
	public void createAccountTest() {
		
		
		CreateAccountDTO dto = new CreateAccountDTO();
		dto.setExternalIdentifier(generateExternalIdentifier());
		dto.setClient(new ClientDTO());
		dto.getClient().setName("ALEX SIMAS BRAZ " + dto.getExternalIdentifier());
		dto.getClient().setTaxIdentifier(new TaxIdentifierDTO());
		dto.getClient().getTaxIdentifier().setTaxId(CPF);
		dto.getClient().getTaxIdentifier().setCountry("BRA");
		dto.getClient().setMobilePhone(new MobilePhoneDTO());
		dto.getClient().getMobilePhone().setPhoneNumber(dto.getExternalIdentifier());
		dto.getClient().setEmail(dto.getExternalIdentifier()+"@gmail.com");
		dto.setBillingAddress(new BillingAddressDTO());
		dto.getBillingAddress().setLogradouro("lOGRADOURO UNICO"+dto.getExternalIdentifier());
		dto.getBillingAddress().setNumero("999");
		dto.getBillingAddress().setBairro("BAIRRO");
		dto.getBillingAddress().setCidade("CIDADE");
		dto.getBillingAddress().setEstado("SP");
		dto.getBillingAddress().setCep("13100CYPHER321");
		dto.getBillingAddress().setPais("BRA");
		
		dto.setClientType("PERSON");
		
		dto.setAccountType("ORDINARY");
		dto.setAdditionalDetailsPerson(new AdditionalDetailsPersonDTO());
		dto.getAdditionalDetailsPerson().setGender("M");
		dto.getAdditionalDetailsPerson().setFather("PAI DO CLIENTE" + dto.getExternalIdentifier());
		dto.getAdditionalDetailsPerson().setMother("MAE DO CLIENTE" + dto.getExternalIdentifier());
		dto.getAdditionalDetailsPerson().setBirthDate("1970-01-01");
		dto.getAdditionalDetailsPerson().setBirthCity("CIDADE");
		dto.getAdditionalDetailsPerson().setBirthState("SP");
		dto.getAdditionalDetailsPerson().setBirthCountry("BRA");
		dto.getAdditionalDetailsPerson().setRg(new RgDTO());
		dto.getAdditionalDetailsPerson().getRg().setNumber("325912840");
		dto.getAdditionalDetailsPerson().getRg().setIssueDate("1980-01-01");
		dto.getAdditionalDetailsPerson().getRg().setIssuer("SSP");
		dto.getAdditionalDetailsPerson().getRg().setState("SP");
		dto.getAdditionalDetailsPerson().setMaritalStatus("SINGLE");
		
		createAccount(dto);
        
	}
	
	@Test
	public void consultarSaldoTest() {
		//assertTrue(response.getStatusCodeValue() == 200);
		String sellerAccount = "AB03C172-4F25-9A24-8C91-7D3DA4A70EB7";
		
		try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String hash = encode(CYPHER, sellerAccount);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
//	    	ResponseEntity<SearchAccountDTO> response = restTemplate.exchange(URI, HttpMethod.GET, String.class );
	    	
	    	String urlCompleta = URI_SEARCH_ACCOUNTS + sellerAccount+"/balance";
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>("", requestHeaders);
	    	
	    	ResponseEntity<String> response = restTemplate.exchange(urlCompleta, HttpMethod.POST, entity, String.class);
	    	
	    	String retorno = (String) response.getBody();
	    	System.out.println(retorno);
	    	System.out.println(response.getStatusCode());
		    assertTrue(response.getStatusCodeValue() == 200);
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	fail();
	    }
		
	}
	
	@Test
	public void saque() {
		String sellerAccount = "AB03C172-4F25-9A24-8C91-7D3DA4A70EB7";
		
		try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
	    	HttpHeaders requestHeaders = new HttpHeaders();
	    	requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    	requestHeaders.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	
	    	String urlCompleta = URI_SEARCH_ACCOUNTS + sellerAccount+"/withdraw";
	    	
	    	WithDrawDTO withDraw = new WithDrawDTO();
	    	withDraw.setWithdrawInfo(new WithdrawInfoDTO());
	    	withDraw.getWithdrawInfo().setBankTransfer(new BankTransferDTO());
	    	withDraw.getWithdrawInfo().getBankTransfer().setTaxIdentifier(new br.com.bjbraz.dto.withdraw.TaxIdentifierDTO());
	    	
	    	withDraw.setTotalAmount("1");
	    	withDraw.setCurrency("BRL");
	    	withDraw.setExternalIdentifier(String.valueOf(System.currentTimeMillis()));
	    	withDraw.setTransactionDate(new Date());
	    	
	    	withDraw.getWithdrawInfo().getBankTransfer().setAccountTypeDestination("1");
	    	withDraw.getWithdrawInfo().getBankTransfer().setBankDestination("341");
	    	withDraw.getWithdrawInfo().getBankTransfer().setBranchDestination("2964");
	    	withDraw.getWithdrawInfo().getBankTransfer().setAccountDestination("051805");
	    	
	    	withDraw.getWithdrawInfo().getBankTransfer().getTaxIdentifier().setCountry("BRA");
	    	withDraw.getWithdrawInfo().getBankTransfer().getTaxIdentifier().setTaxId("76683272743");
	    	
	    	
	    	withDraw.getWithdrawInfo().getBankTransfer().setPersonType("PERSON");
	    	withDraw.getWithdrawInfo().getBankTransfer().setName("CONTA 13902836901");
	    	withDraw.getWithdrawInfo().getBankTransfer().setAccountDestination("1");
	    	
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
	    	System.out.println(retorno);
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
	public void createAccount(CreateAccountDTO dto) {
	    
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
		    assertTrue(response.getStatusCodeValue() == 200);
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	fail();
	    }
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
	
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