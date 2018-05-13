package br.com.bjbraz.dto.account;

import java.io.Serializable;


/**
 * 
 * @author asimas
 *
 */
public class TaxIdentifierDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3277887977420408261L;
	
	/*
	"taxIdentifier": {
	      "taxId": "{{CPF}}",
	      "country": "BRA"
	    },
	 */
	
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
