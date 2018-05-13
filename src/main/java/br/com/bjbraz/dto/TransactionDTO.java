package br.com.bjbraz.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import br.com.bjbraz.domain.Account;
import br.com.bjbraz.domain.OperationType;
import br.com.bjbraz.domain.Transaction;

/**
 * 
 * @author alex.braz
 *
 */
public class TransactionDTO implements Serializable{
	
	public TransactionDTO(){}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 981684797813806867L;
	
	private Long id;
	private Date transactionDate;
	private Account account;
	private BigDecimal value;
    private OperationType operationType;
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
	
	/**
	 * 
	 * @param t
	 */
	public TransactionDTO(Transaction t){
		this.setId(t.getId());
		this.setAccount(t.getAccount());
		this.setTransactionDate(t.getTransactionDate());
		this.setOperationType(t.getOperationType());
		this.setValue(t.getValue());
	}

	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String getFormatedDate(Date time) {

		try {
			
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-02:00"));
			
			return simpleDateFormat.format(time);
			
		} catch (Exception e) {
			return "*Data inválida*";
		}

	}

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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public String getValorString() {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	@JsonSerialize(using=DoubleSerializer.class)
	@JsonProperty("valor")	
	public Double getValor() {
		return value.doubleValue();
	}	

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

}
