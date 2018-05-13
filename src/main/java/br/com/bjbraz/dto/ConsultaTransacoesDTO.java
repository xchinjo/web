package br.com.bjbraz.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;

public class ConsultaTransacoesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2291329610167813128L;
	private List<TransactionDTO> itens = new ArrayList<TransactionDTO>();

	@JsonSerialize(typing = Typing.STATIC)
	public List<TransactionDTO> getItens() {
		return itens;
	}

	public void setItens(List<TransactionDTO> itens) {
		this.itens = itens;
	}
	
	

}
