package br.com.bjbraz.domain;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

@Entity
@Table(name = "transacao")
public class Transaction  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2086719031217218783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction")
	private Long id;

	@Column(name = "dh_transaction")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_conta_associada")
	private Account account;

	@Column(name = "vlr_valor", nullable = false)
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	@Column(name="operation_type")
    private OperationType operationType;
 	
	
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getValue() {
		return value;
	}

}