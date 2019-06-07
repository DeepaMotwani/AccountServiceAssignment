package com.accountservice.service;

import com.accountservice.model.Customer;

public interface AccountDetailsService {
	
	public Customer getAccountDetails(String customerId);

}
