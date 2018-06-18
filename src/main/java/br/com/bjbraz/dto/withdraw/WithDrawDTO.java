package br.com.bjbraz.dto.withdraw;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class WithDrawDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3182365449412101037L;
	
	private String totalAmount;
	private String currency;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "America/Sao_Paulo")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
    private Date transactionDate;
	
	private WithdrawInfoDTO withdrawInfo;
	
	private String externalIdentifier;

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String amount) {
		this.totalAmount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public WithdrawInfoDTO getWithdrawInfo() {
		return withdrawInfo;
	}

	public void setWithdrawInfo(WithdrawInfoDTO withdrawInfo) {
		this.withdrawInfo = withdrawInfo;
	}

	public String getExternalIdentifier() {
		return externalIdentifier;
	}

	public void setExternalIdentifier(String externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

}