package com.accountservice.service;

import com.accountservice.model.CurrentAccountData;
import com.accountservice.model.CustomerData;

public interface AccountCreationService {
	
	public CurrentAccountData addCurrentAccount(String customerId, Double initialCredit);
	
	public CustomerData customerDetails(CustomerData customerData);

}
