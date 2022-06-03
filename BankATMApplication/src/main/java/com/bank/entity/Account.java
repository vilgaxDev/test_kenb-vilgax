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

/**
 * @author Kenb.vilgax
 *
 */
@Table
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private String accountNo;
	private double totalBalance;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="account")
	private List<Transactions>transactionList;
	
	
	public List<Transactions> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transactions> transactionList) {
		this.transactionList = transactionList;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNo=" + accountNo + ", totalBalance=" + totalBalance + ", customer="
				+ customer + ", transactionList=" + transactionList + "]";
	}

}
