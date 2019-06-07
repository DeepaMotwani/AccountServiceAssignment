package com.accountservice.service;

import com.accountservice.model.TransactionHistory;

public interface AccountTransactionService {
	
	public TransactionHistory saveTransasction(String customerId, Long accountId, TransactionHistory transactionDetails);
}
