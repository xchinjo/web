package br.com.bjbraz.dto.withdraw;

import java.io.Serializable;

public class WithdrawInfoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3193007213838460233L;

	private String withdrawType = "BankTransfer";
	
	private BankTransferDTO bankTransfer;

	public String getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}

	public BankTransferDTO getBankTransfer() {
		return bankTransfer;
	}

	public void setBankTransfer(BankTransferDTO bankTransfer) {
		this.bankTransfer = bankTransfer;
	}
	
	

}
