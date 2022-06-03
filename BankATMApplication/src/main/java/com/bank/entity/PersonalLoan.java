package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Kenb.vilgax
 *
 */
@Component
@Entity
@Table
public class PersonalLoan 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lid;
	private double salary;
	private double loanEMI;
	private double loanAmount;
	public int loanDuration;
	public double interestRate;
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getLoanEMI() {
		return loanEMI;
	}
	public void setLoanEMI(double loanEMI) {
		this.loanEMI = loanEMI;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}
	@Override
	public String toString() {
		return "PersonalLoan [lid=" + lid + ", salary=" + salary + ", loanEMi=" + loanEMI + ", loanAmount=" + loanAmount
				+ "]";
	}
	
}
