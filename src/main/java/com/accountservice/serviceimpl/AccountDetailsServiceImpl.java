package com.accountservice.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.model.CurrentAccountData;
import com.accountservice.model.Customer;
import com.accountservice.model.CustomerData;
import com.accountservice.model.TransactionHistory;
import com.accountservice.repository.CustomerAccountRepository;
import com.accountservice.repository.CustomerDataRepository;
import com.accountservice.repository.TransactionRepository;
import com.accountservice.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);
	
	@Autowired
	CustomerDataRepository customerDataRepository;
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Customer getAccountDetails(String customerId) {
		Customer customer = new Customer();
		List<CustomerData> customerData = customerDataRepository.getCustomerDataByCustomerId(customerId);
		if(customerData.size()!=0){
		customer.setCustomerData(customerData.get(0));
		List<CurrentAccountData> accountList = customerAccountRepository.getCutomerAccounts(customerId);
		List<TransactionHistory> transactionHistory = new ArrayList<>();
		customer.setCurrentAccountList(accountList);
		for(CurrentAccountData currentAccount : accountList){
			List<TransactionHistory> transactionList = transactionRepository.getAccountTransactions(currentAccount.getAccountId());
			transactionHistory.addAll(transactionList);
		}
		customer.setTransactionHistory(transactionHistory);
		return customer;
		}else{
			LOGGER.debug("customer does not exist");
			return null;
		}
	}

}
