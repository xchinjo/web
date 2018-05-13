package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class MobilePhoneDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1520274897960659189L;
	private String country = "BRA";
	private String phoneNumber;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*
	
	"mobilePhone": {
    "country": "BRA",
    "phoneNumber": "{{Sequencial}}"
  },
  
  */

}
