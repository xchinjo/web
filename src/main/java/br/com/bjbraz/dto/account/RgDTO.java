package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class RgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1503583348836098487L;
	
	/*
	 "rg": {
	      "number": "325912840",
	      "issueDate": "1980-01-01",
	      "issuer": "SSP",
	      "state":"SP"
      },
      */
	
	private String number;
	private String issueDate;
	private String state;
	private String issuer;
	
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
