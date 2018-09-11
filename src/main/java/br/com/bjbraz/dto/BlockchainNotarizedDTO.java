package br.com.bjbraz.dto;

import java.util.Date;

/**
 * 
 * @author asimas
 *
 */
public class BlockchainNotarizedDTO {

	private Long id;
	private Date transactionDate;
	private String documentHash;
	private String blockchainHash;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDocumentHash() {
		return documentHash;
	}

	public void setDocumentHash(String documentHash) {
		this.documentHash = documentHash;
	}

	public String getBlockchainHash() {
		return blockchainHash;
	}

	public void setBlockchainHash(String blockchainHash) {
		this.blockchainHash = blockchainHash;
	}	

}
