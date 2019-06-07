package com.accountservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accountservice.model.Customer;
import com.accountservice.model.CustomerData;
import com.accountservice.model.TransactionHistory;
import com.accountservice.service.AccountCreationService;
import com.accountservice.service.AccountDetailsService;
import com.accountservice.service.AccountTransactionService;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class AccountServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AccountDetailsService accountService;
	
	@Autowired
	private AccountCreationService accountCreationService;
	
	@Autowired
	private AccountTransactionService accountTransactionService;
	
	@GetMapping(value="getCustomerDetails/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerId") String customerId){
		 return ResponseEntity.ok(accountService.getAccountDetails(customerId));
	 }
	
	@PostMapping(value = "/addCustomerDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addCustomerDetails(@RequestBody CustomerData customerData) {
		return accountCreationService.customerDetails(customerData);
		
	}
	
	@PostMapping(value = "/addCustomerAccount/{customerId}/{initialCredit}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addCustomerAccount(@PathVariable("customerId") String customerId,@PathVariable("initialCredit") Double initialCredit) {
		return accountCreationService.addCurrentAccount(customerId,initialCredit);
		
	}
	
	@PostMapping(value = "/addAccountTransaction/{customerId}/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addAccountTransaction(@PathVariable("customerId") String customerId,@PathVariable("accountId") Long accountId, @RequestBody TransactionHistory transactionDetails) {
		return accountTransactionService.saveTransasction(customerId,accountId, transactionDetails);
		
	}

}
