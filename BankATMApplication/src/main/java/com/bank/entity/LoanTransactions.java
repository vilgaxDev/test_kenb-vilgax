package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Kenb.vilgax
 *
 */
@Entity
@Table
@Component
public class LoanTransactions 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ltid;
	private String transactionType=null;
	private double emi;
	private String transDate;
	private double closingBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loanAccountId", nullable = false)
	private LoanAccount loanAccount;

	public Integer getLtid() {
		return ltid;
	}

	public void setLtid(Integer ltid) {
		this.ltid = ltid;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

	@Override
	public String toString() {
		return "LoanTransactions [ltid=" + ltid + ", transactionType=" + transactionType + ", emi=" + emi
				+ ", transDate=" + transDate + ", closingBalance=" + closingBalance + ", loanAccount=" + loanAccount
				+ "]";
	}
	
	
}
