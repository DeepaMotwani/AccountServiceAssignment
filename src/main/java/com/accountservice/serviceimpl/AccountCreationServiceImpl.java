package com.accountservice.serviceimpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.model.CurrentAccountData;
import com.accountservice.model.CustomerData;
import com.accountservice.model.TransactionHistory;
import com.accountservice.repository.CustomerAccountRepository;
import com.accountservice.repository.CustomerDataRepository;
import com.accountservice.repository.TransactionRepository;
import com.accountservice.service.AccountCreationService;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountCreationServiceImpl.class);
	
	@Autowired
	CustomerDataRepository customerDataRepository;
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public CurrentAccountData addCurrentAccount(String customerId, Double initialCredit) {
		CurrentAccountData customerAccountData = new CurrentAccountData();
		customerAccountData.setBalance(initialCredit);
		List<CustomerData> customerData = customerDataRepository.getCustomerDataByCustomerId(customerId);
		if(customerData.size()!=0){
		customerAccountData.setCustomerData(customerData.get(0));
		CurrentAccountData customerSavedAccount = customerAccountRepository.save(customerAccountData);
		if(initialCredit!=0){
			
			TransactionHistory transactionHistory = new TransactionHistory();
			transactionHistory.setCreditedTo(customerSavedAccount.getAccountId().toString());
			transactionHistory.setDebitedFrom("Initial Credit");
			transactionHistory.setCustomerAccountData(customerSavedAccount);
			transactionHistory.setTransactionAmount(initialCredit);
			transactionHistory.setTransactionDate(new Date());
			
			transactionRepository.save(transactionHistory);
		}
		LOGGER.debug("Customer data returned.......");
		return customerSavedAccount;
		}
		else{
			LOGGER.debug("Customer does not exist");
			return null;
		}
	}

	@Override
	public CustomerData customerDetails(CustomerData customerData) {
		return customerDataRepository.save(customerData);
	}

}
