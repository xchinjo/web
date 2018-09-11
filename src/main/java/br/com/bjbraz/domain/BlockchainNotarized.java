package br.com.bjbraz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "blockchain_notarized")
public class BlockchainNotarized implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4678368176458513269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_blockchain_notarized")
	private Long id;

	@Column(name = "dh_transaction")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@Column(name = "document_hash", nullable = false)
	private String documentHash;
	
	@Column(name = "blockchain_hash", nullable = false)
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
