package br.com.bjbraz.dto.account;

import java.io.Serializable;
import java.util.List;

public class DataSearchAccountDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5644601998162281140L;
	private String accountHolderId;
	private BillingAddressDTO billingAddress;
	private AccountDTO account;
	private ClientDTO client;
	private AdditionalDetailsCorporateDTO additionalDetailsCorporate;
	private String accountStatus;
	private String clientType;
	private List<BalanceDTO> balances;
	
	public String getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public BillingAddressDTO getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddressDTO billingAddress) {
		this.billingAddress = billingAddress;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	public AdditionalDetailsCorporateDTO getAdditionalDetailsCorporate() {
		return additionalDetailsCorporate;
	}
	public void setAdditionalDetailsCorporate(AdditionalDetailsCorporateDTO additionalDetailsCorporate) {
		this.additionalDetailsCorporate = additionalDetailsCorporate;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public List<BalanceDTO> getBalances() {
		return balances;
	}
	public void setBalances(List<BalanceDTO> balances) {
		this.balances = balances;
	}

}
