package com.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accountservice.model.CurrentAccountData;
import com.accountservice.model.CustomerData;
@Repository
public interface CustomerAccountRepository extends JpaRepository<CurrentAccountData, Long>{
	
	@Query("select cad from CurrentAccountData cad where cad.accountId=?1")
	List<CurrentAccountData> getCustomerAccountDetailsByAccountId(Long accountId);
	
	@Query("select cad from CurrentAccountData cad where cad.customerData.customerId=?1")
	List<CurrentAccountData> getCutomerAccounts(String customerId);

}
