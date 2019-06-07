package com.accountservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction_details")
public class TransactionHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "transaction_date")
	private Date transactionDate;
	@Column(name = "debited_from")
	private String debitedFrom;
	@Column(name = "credited_to")
	private String creditedTo;
	@Column(name = "transaction_amount")
	private Double transactionAmount;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CurrentAccountData customerAccountData;

	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDebitedFrom() {
		return debitedFrom;
	}
	public void setDebitedFrom(String debitedFrom) {
		this.debitedFrom = debitedFrom;
	}
	public String getCreditedTo() {
		return creditedTo;
	}
	public void setCreditedTo(String creditedTo) {
		this.creditedTo = creditedTo;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CurrentAccountData getCustomerAccountData() {
		return customerAccountData;
	}
	public void setCustomerAccountData(CurrentAccountData customerAccountData) {
		this.customerAccountData = customerAccountData;
	}
	public TransactionHistory() {
		super();
	}
	public TransactionHistory(Long id, Date transactionDate, String debitedFrom, String creditedTo,
			Double transactionAmount, CurrentAccountData customerAccountData) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.debitedFrom = debitedFrom;
		this.creditedTo = creditedTo;
		this.transactionAmount = transactionAmount;
		this.customerAccountData = customerAccountData;
	}
	@Override
	public String toString() {
		return "TransactionHistory [id=" + id + ", transactionDate=" + transactionDate + ", debitedFrom=" + debitedFrom
				+ ", creditedTo=" + creditedTo + ", transactionAmount=" + transactionAmount + ", customerAccountData="
				+ customerAccountData + "]";
	}

	

}
