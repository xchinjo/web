package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class CreateAccountDTO implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 8572773231768100051L;
		
		private String externalIdentifier;
		private boolean sharedAccount = false;
		private Integer creditDate = 32;
		private ClientDTO client;
		private String clientType; //PERSON or CORPORATE
		private String accountType;
		private BillingAddressDTO billingAddress;
		private AdditionalDetailsPersonDTO additionalDetailsPerson;
		
		public AdditionalDetailsPersonDTO getAdditionalDetailsPerson() {
			return additionalDetailsPerson;
		}
		public void setAdditionalDetailsPerson(AdditionalDetailsPersonDTO additionalDetailsPerson) {
			this.additionalDetailsPerson = additionalDetailsPerson;
		}
		public String getExternalIdentifier() {
			return externalIdentifier;
		}
		public void setExternalIdentifier(String externalIdentifier) {
			this.externalIdentifier = externalIdentifier;
		}
		public boolean isSharedAccount() {
			return sharedAccount;
		}
		public void setSharedAccount(boolean sharedAccount) {
			this.sharedAccount = sharedAccount;
		}
		public Integer getCreditDate() {
			return creditDate;
		}
		public void setCreditDate(Integer creditDate) {
			this.creditDate = creditDate;
		}
		public ClientDTO getClient() {
			return client;
		}
		public void setClient(ClientDTO client) {
			this.client = client;
		}
		public String getClientType() {
			return clientType;
		}
		public void setClientType(String clientType) {
			this.clientType = clientType;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public BillingAddressDTO getBillingAddress() {
			return billingAddress;
		}
		public void setBillingAddress(BillingAddressDTO billingAddress) {
			this.billingAddress = billingAddress;
		}
		
		
		/*

		{
		  "externalIdentifier": "{{Sequencial}}",
		  "sharedAccount": false,
		  "creditDate": 32,
		  "client": {
		    "name": "CONTA PF SUBORDINADA - {{Sequencial}}",
		    "taxIdentifier": {
		      "taxId": "{{CPF}}",
		      "country": "BRA"
		    },
		    "mobilePhone": {
		      "country": "BRA",
		      "phoneNumber": "{{Sequencial}}"
		    },
		    "email": "cliente.pf.{{Sequencial}}{{Email}}"
		  },
		  "billingAddress": {
		    "logradouro": "LOGRADOURO CLIENTE PF {{Sequencial}}",
		    "numero": "999",
		    "bairro":"BAIRRO",
		    "cidade":"CIDADE",
		    "estado":"SP",
		    "cep":"13100321",
		    "pais":"BRA"
		  },
		  "clientType": "PERSON",
		  "accountType": "{{accountType}}",
		  "additionalDetailsPerson": {
		    "gender": "M",
		    "father": "PAI DO CLIENTE PF {{Sequencial}}",
		    "mother": "MAE DO CLIENTE PF {{Sequencial}}",
		    "birthDate": "1970-01-01",
		    "birthCity": "CIDADE",
		    "birthState": "SP",
		    "birthCountry": "BRA",
		    "rg": {
		      "number": "325912840",
		      "issueDate": "1980-01-01",
		      "issuer": "SSP",
		      "state":"SP"
		    },
		    "maritalStatus": "SINGLE"
		  }
		}


			 * */
		
		
	
}
