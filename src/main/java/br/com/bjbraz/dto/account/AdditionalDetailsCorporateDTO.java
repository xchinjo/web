package br.com.bjbraz.dto.account;

import java.io.Serializable;
import java.util.List;

public class AdditionalDetailsCorporateDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 34042318243628743L;

	public List<RepresentativeDTO> representatives;
	public RepresentativeDTO representative;

	public List<RepresentativeDTO> getRepresentatives() {
		return representatives;
	}

	public void setRepresentatives(List<RepresentativeDTO> representatives) {
		this.representatives = representatives;
	}

	public RepresentativeDTO getRepresentative() {
		return representative;
	}

	public void setRepresentative(RepresentativeDTO representative) {
		this.representative = representative;
	}
	
	

}
