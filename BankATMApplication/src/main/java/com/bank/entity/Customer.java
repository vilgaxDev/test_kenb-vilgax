package com.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Kenb.vilgax
 *
 */
@Table
@EnableTransactionManagement
@Entity
@Component
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String firstName, lastName, address, mobileNo,bankNo, amount,amount_sent ,email, mobile;
	private String  password;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Account account;

	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private LoanAccount loanAccount;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getbankNo() {
		return bankNo;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}

	public void setamount_sent(String amount_sent) {
		this.amount_sent = amount_sent;
	}
	public String getAmount_sent() {
		return amount_sent;
	}

	public void setbankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstName=" + firstName + "bankNo" +bankNo + "amount_sent" + amount_sent +", lastName=" + lastName + ", address=" + address
				+ ", mobileNo=" + mobileNo   + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + "]";
	}

}


