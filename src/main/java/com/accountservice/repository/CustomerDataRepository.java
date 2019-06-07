package com.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accountservice.model.CustomerData;
import com.accountservice.model.TransactionHistory;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, String>{
	
	@Query("select cd from CustomerData cd where cd.customerId=?1")
	List<CustomerData> getCustomerDataByCustomerId(String customerId);
	
	

}
