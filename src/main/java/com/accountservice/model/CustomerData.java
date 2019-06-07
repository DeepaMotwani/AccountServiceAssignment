package com.accountservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerData {
	
	@Id
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "balance")
	private Double balance;
	@Column(name ="account_number")
	private Long accountNumber;

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public CustomerData() {
		super();
	}
	public CustomerData(String customerId, String firstName, String lastName, Double balance, Long accountNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

}
