package br.com.bjbraz.test;

import static br.com.bjbraz.spring.ContractRestURIConstants.API_KEY;
import static br.com.bjbraz.spring.ContractRestURIConstants.CPF;
import static br.com.bjbraz.spring.ContractRestURIConstants.CYPHER;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI;
import static br.com.bjbraz.spring.ContractRestURIConstants.encode;
import static br.com.bjbraz.spring.ContractRestURIConstants.generateExternalIdentifier;
import static br.com.bjbraz.spring.ContractRestURIConstants.toJson;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.bjbraz.dto.account.AdditionalDetailsPersonDTO;
import br.com.bjbraz.dto.account.BillingAddressDTO;
import br.com.bjbraz.dto.account.ClientDTO;
import br.com.bjbraz.dto.account.CreateAccountDTO;
import br.com.bjbraz.dto.account.MobilePhoneDTO;
import br.com.bjbraz.dto.account.RgDTO;
import br.com.bjbraz.dto.account.SearchAccountDTO;
import br.com.bjbraz.dto.account.TaxIdentifierDTO;

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
	    	
	    	String valoresHash = dto.getExternalIdentifier()+CPF;
	    	String hash = encode(CYPHER, valoresHash);
	    	
	    	requestHeaders.add("transaction-hash", hash);
	    	
	    	HttpEntity<String> entity = new HttpEntity<String>(toJson(dto), requestHeaders);
	    	ResponseEntity<SearchAccountDTO> response = restTemplate.exchange(URI, HttpMethod.POST, entity, SearchAccountDTO.class);
	    	System.out.println(response.getBody());
	    	System.out.println(response.getStatusCode());
		    assertTrue(response.getStatusCodeValue() == 200);
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	fail();
	    }
	}
	
	public boolean create2(CreateAccountDTO dto) {

	    try {
	    	ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			
			RestTemplate restTemplate = new RestTemplate(requestFactory);
	    	
	    	HttpHeaders headers = new HttpHeaders();
	 	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 	    headers.setContentType(MediaType.APPLICATION_JSON);
	 	    
	    	String valoresHash = dto.getExternalIdentifier()+CPF;
	    	String hash = encode(CYPHER, valoresHash);
	    	
	 	    headers.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	 	    headers.add("transaction-hash", hash);
//	 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 	    
	    	MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
//	    	postParameters.add("api-access-key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
//	    	postParameters.add("transaction-hash", hash);
	 	    
	    	HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

	    	System.out.println(valoresHash);
	    	System.out.println(hash);
	    	System.out.println(toJson(dto));
	    	
	    	Object result = restTemplate.postForObject( URI, dto, CreateAccountDTO.class, headers);
	    	System.out.println(result);
	    	return true;
	    }catch(Exception e) {
	    	log.error(e.getMessage());
	    	return false;
	    }	    
	}
	
    public boolean create3(CreateAccountDTO dto){
    	try {
	        CloseableHttpClient client = HttpClients.createDefault();
	        HttpPost httpPost = new HttpPost(URI);
	        
	        String valoresHash = dto.getExternalIdentifier()+CPF;
	    	String hash = encode(API_KEY, valoresHash);
	     
	        StringEntity entity = new StringEntity(toJson(dto));
	        httpPost.setEntity(entity);
	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setHeader("Content-type", "application/json");
	        httpPost.setHeader("Api-Access-Key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	        httpPost.setHeader("Transaction-Hash", hash);
	     
	        CloseableHttpResponse response = client.execute(httpPost);
	        System.out.println(response.getStatusLine().getStatusCode());
	        client.close();
	        return (response.getStatusLine().getStatusCode() == 200);
	        
    	}catch(Exception e) {
	    	log.error(e.getMessage());
	    	return false;
    	}
    }
    
    public boolean create4(CreateAccountDTO dto) {
    	try {
    		
	        String valoresHash = dto.getExternalIdentifier()+CPF;
	    	String hash = encode(API_KEY, valoresHash);
	
	    	HttpHeaders httpHeaders = new HttpHeaders();
	    	httpHeaders.set("Content-Type", "application/json");
	    	httpHeaders.set("Accept", "application/json");
	    	httpHeaders.set("Content-type", "application/json");
	    	httpHeaders.set("Api-Access-Key", "36BE5D3F-61DD-4836-AE21-39D7A8A686D6");
	    	httpHeaders.set("Transaction-Hash", hash);	    	
	
	    	HttpEntity <String> httpEntity = new HttpEntity <String> (toJson(dto), httpHeaders);
	
	    	RestTemplate restTemplate = new RestTemplate();
	    	String response = restTemplate.postForObject(URI, httpEntity, String.class);
	
	    	JSONObject jsonObj = new JSONObject(response);
	    	String balance = jsonObj.get("data").toString();
	    	return true;
    	}catch(Exception e) {
    		log.error(e.getMessage());
    		return false;
    	}
    }
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
 
	
}
