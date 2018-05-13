package br.com.bjbraz.dto.account;

import java.io.Serializable;

/**
 * 
 * @author asimas
 *
 */
public class AdditionalDetailsPersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8061722752856540846L;
	
	private String gender;
	private String father;
	private String mother;
	private String birthDate;
	private String birthCity;
	private String birthState;
	private String birthCountry;
	private RgDTO rg;
	private String maritalStatus;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthCity() {
		return birthCity;
	}
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	public String getBirthState() {
		return birthState;
	}
	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}
	public String getBirthCountry() {
		return birthCountry;
	}
	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}
	public RgDTO getRg() {
		return rg;
	}
	public void setRg(RgDTO rg) {
		this.rg = rg;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	/*
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
	 * 
	 * */
	

}
