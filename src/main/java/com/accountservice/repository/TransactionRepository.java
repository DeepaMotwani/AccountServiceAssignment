package com.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accountservice.model.TransactionHistory;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory , Integer> {
	
	@Query("select th from TransactionHistory th where th.customerAccountData.accountId=?1")
	List<TransactionHistory> getAccountTransactions(Long accountId);

}
