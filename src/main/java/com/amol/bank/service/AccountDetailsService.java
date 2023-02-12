package com.amol.bank.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.bank.entity.AccountDetails;
import com.amol.bank.repo.AccountDetailsRepo;

@Service
public class AccountDetailsService {

	@Autowired
	AccountDetailsRepo accountDetailsRepo;
	
//	@Autowired
//	AccountDetails accountDetails;
//	int tempAccountNumber = accountDetails.getAccountNumber();
	public AccountDetails addAccountDetails(AccountDetails accountDetails) {
		return accountDetailsRepo.save(accountDetails);
	}

	public AccountDetails getAccountDetails(int accountNumber) {
		return accountDetailsRepo.findById(accountNumber).orElse(null);
	}

	
	
	
}
