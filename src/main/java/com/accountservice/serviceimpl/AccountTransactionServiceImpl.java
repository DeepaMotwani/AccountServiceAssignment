package com.accountservice.serviceimpl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.model.TransactionHistory;
import com.accountservice.repository.CustomerAccountRepository;
import com.accountservice.repository.CustomerDataRepository;
import com.accountservice.repository.TransactionRepository;
import com.accountservice.service.AccountTransactionService;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionServiceImpl.class);

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerDataRepository customreDataRepository;
	
	@Autowired
	CustomerAccountRepository  customerAccountRepository;
	
	@Override
	public TransactionHistory saveTransasction(String customerId, Long accountId, TransactionHistory transactionDetails) {
		transactionDetails.setCustomerAccountData(customerAccountRepository.getCustomerAccountDetailsByAccountId(accountId).get(0));
		transactionDetails.setTransactionDate(new Date());
		LOGGER.debug("transaction details retrieved.......");
		return transactionRepository.save(transactionDetails);
	}

}
