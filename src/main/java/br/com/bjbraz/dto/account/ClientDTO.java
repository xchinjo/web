package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6979211233813308795L;
	private String name;
	private TaxIdentifierDTO taxIdentifier;
	private MobilePhoneDTO mobilePhone;
	private String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TaxIdentifierDTO getTaxIdentifier() {
		return taxIdentifier;
	}
	public void setTaxIdentifier(TaxIdentifierDTO taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}
	public MobilePhoneDTO getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(MobilePhoneDTO mobilePhone) {
		this.mobilePhone = mobilePhone;
	}	
	
	/**
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
	 */

}
