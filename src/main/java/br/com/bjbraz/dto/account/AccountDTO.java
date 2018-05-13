package br.com.bjbraz.dto.account;

import java.io.Serializable;

public class AccountDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 550674420030677926L;
	private String accountId;
	private Integer account;
	private Integer branch;
	private MobilePhoneDTO mobilePhone;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public MobilePhoneDTO getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(MobilePhoneDTO mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
