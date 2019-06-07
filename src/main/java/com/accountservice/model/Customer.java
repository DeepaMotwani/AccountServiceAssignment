package com.accountservice.model;

import java.util.List;
import java.util.Optional;

public class Customer {
	
	private CustomerData customerData;
	private List<CurrentAccountData> currentAccountList;
	private List<TransactionHistory> transactionHistory;

	public CustomerData getCustomerData() {
		return customerData;
	}
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
	public List<CurrentAccountData> getCurrentAccountList() {
		return currentAccountList;
	}
	public void setCurrentAccountList(List<CurrentAccountData> currentAccountList) {
		this.currentAccountList = currentAccountList;
	}
	public List<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
	public Customer(CustomerData customerData, List<CurrentAccountData> currentAccountList,
			List<TransactionHistory> transactionHistory) {
		super();
		this.customerData = customerData;
		this.currentAccountList = currentAccountList;
		this.transactionHistory = transactionHistory;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerData=" + customerData + "]";
	}
	

}
