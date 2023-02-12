package com.amol.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.bank.entity.AccountDetails;
import com.amol.bank.entity.Transaction;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails, Integer> {

	 
//	Transaction save(double currentBalance);
	
	
	
}
