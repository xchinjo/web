package br.com.bjbraz.dto.account;

import java.io.Serializable;

public class SearchAccountDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 432142556681129685L;
	private DataSearchAccountDTO data;
	
	public DataSearchAccountDTO getData() {
		return data;
	}
	public void setData(DataSearchAccountDTO data) {
		this.data = data;
	}

}
