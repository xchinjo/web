package br.com.bjbraz.dto.account;

import java.io.Serializable;

public class BillingAddressDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3852898958033017875L;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String pais = "BRA";
	
	/*
	
	"billingAddress": {
	    "logradouro": "LOGRADOURO CLIENTE PF {{Sequencial}}",
	    "numero": "999",
	    "bairro":"BAIRRO",
	    "cidade":"CIDADE",
	    "estado":"SP",
	    "cep":"13100321",
	    "pais":"BRA"
	  },
	
	*/
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
