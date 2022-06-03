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
@Table
@Entity
@Component
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;
	private String transactionType=null;
	private double ammount;
	private String transDate;
	private double closingBalance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid", nullable = false)
	private Account account;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String date) {
		this.transDate = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Override
	public String toString() {
		return "Transactions [tid=" + tid + ", transactionType=" + transactionType + ", ammount=" + ammount
				+ ", transDate=" + transDate + ", closingBalance=" + closingBalance + ", account=" + account + "]";
	}


}
