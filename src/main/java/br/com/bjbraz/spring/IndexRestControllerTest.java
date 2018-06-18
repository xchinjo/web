package br.com.bjbraz.spring;

import static br.com.bjbraz.spring.ContractRestURIConstants.CPF;
import static br.com.bjbraz.spring.ContractRestURIConstants.CYPHER;
import static br.com.bjbraz.spring.ContractRestURIConstants.URI_SEARCH_ACCOUNTS;
import static br.com.bjbraz.spring.ContractRestURIConstants.encode;
import static br.com.bjbraz.spring.ContractRestURIConstants.generateExternalIdentifier;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.bjbraz.dto.account.AdditionalDetailsPersonDTO;
import br.com.bjbraz.dto.account.BillingAddressDTO;
import br.com.bjbraz.dto.account.ClientDTO;
import br.com.bjbraz.dto.account.CreateAccountDTO;
import br.com.bjbraz.dto.account.MobilePhoneDTO;
import br.com.bjbraz.dto.account.RgDTO;
import br.com.bjbraz.dto.account.TaxIdentifierDTO;
import br.com.bjbraz.dto.withdraw.BankTransferDTO;
import br.com.bjbraz.dto.withdraw.WithDrawDTO;
import br.com.bjbraz.dto.withdraw.WithdrawInfoDTO;

/**
 * 
 * @author asimas
 *
 */
@RestController
public class IndexRestControllerTest {
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.CRIAR_CONTA_PF_TEST, method = RequestMethod.GET)	
	public CreateAccountDTO teste() {
		
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
		return dto;
	}
	
	@RequestMapping(value = ContractRestURIConstants.SAQUE_TEST, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public WithDrawDTO saque() {
			String sellerAccount = "AB03C172-4F25-9A24-8C91-7D3DA4A70EB7";
		
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
	    	
	    	
	    	return withDraw;
	}	

}
