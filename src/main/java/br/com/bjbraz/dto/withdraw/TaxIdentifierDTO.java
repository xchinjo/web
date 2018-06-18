package br.com.bjbraz.dto.withdraw;

import java.io.Serializable;

public class TaxIdentifierDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2739265823823776054L;
	private String taxId;
	private String country = "BRA";
	
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	} 

}
