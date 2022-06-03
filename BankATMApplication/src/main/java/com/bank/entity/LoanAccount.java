package com.bank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Kenb.vilgax
 *
 */
@Entity
@Component
@Table
public class LoanAccount
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer loanAccountId;
private String loanAccountNumber;
private double loanBalance;
private int loanDuration;
private double loanEMI;
public double interestRate;
public int loanEMIRemaining;


@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
private Customer customer;


@OneToMany(cascade = CascadeType.ALL,mappedBy="loanAccount")
private List<LoanTransactions>loanTransactionList;

public int getLoanEMIRemaining() {
	return loanEMIRemaining;
}
public void setLoanEMIRemaining(int loanEMIRemaining) {
	this.loanEMIRemaining = loanEMIRemaining;
}
public double getLoanEMI() {
	return loanEMI;
}
public void setLoanEMI(double loanEMI) {
	this.loanEMI = loanEMI;
}
public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}
public String getLoanAccountNumber() {
	return loanAccountNumber;
}
public void setLoanAccountNumber(String loanAccountNumber) {
	this.loanAccountNumber = loanAccountNumber;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Integer getLoanAccountId() {
	return loanAccountId;
}
public void setLoanAccountId(Integer loanAccountId) {
	this.loanAccountId = loanAccountId;
}

public double getLoanBalance() {
	return loanBalance;
}
public void setLoanBalance(double loanBalance) {
	this.loanBalance = loanBalance;
}

public int getLoanDuration() {
	return loanDuration;
}
public void setLoanDuration(int loanDuration) {
	this.loanDuration = loanDuration;
}


public List<LoanTransactions> getLoanTransactionList() {
	return loanTransactionList;
}
public void setLoanTransactionList(List<LoanTransactions> loanTransactionList) {
	this.loanTransactionList = loanTransactionList;
}
@Override
public String toString() {
	return "LoanAccount [loanAccountId=" + loanAccountId + ", loanAccountNumber=" + loanAccountNumber + ", loanBalance="
			+ loanBalance + ", loanDuration=" + loanDuration + ", loanEMI=" + loanEMI + ", interestRate=" + interestRate
			+ ", customer=" + customer + "]";
}

}
