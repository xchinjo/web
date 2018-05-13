package br.com.bjbraz.dto.account;

import java.io.Serializable;

public class RepresentativeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2015500194606857063L;
	private String name;
	private String email;
	private TaxIdentifierDTO taxIdentifier;
	private MobilePhoneDTO mobile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TaxIdentifierDTO getTaxIdentifier() {
		return taxIdentifier;
	}
	public void setTaxIdentifier(TaxIdentifierDTO taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}
	public MobilePhoneDTO getMobile() {
		return mobile;
	}
	public void setMobile(MobilePhoneDTO mobile) {
		this.mobile = mobile;
	}
	
	

}
