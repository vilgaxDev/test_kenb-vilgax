package com.bank.dto;

/**
 * @author Kenb.vilgax
 *
 */
public class TransferDTO 
{
	private String accountNo;
	private double amount;
	private double loanEMI;
	private String loanAccountNumber;
	
	public double getLoanEMI() {
		return loanEMI;
	}
	public void setLoanEMI(double loanEMI) {
		this.loanEMI = loanEMI;
	}
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransferDTO [accountNo=" + accountNo + ", amount=" + amount + ", loanEMI=" + loanEMI
				+ ", loanAccountNumber=" + loanAccountNumber + "]";
	}
	
	
}
