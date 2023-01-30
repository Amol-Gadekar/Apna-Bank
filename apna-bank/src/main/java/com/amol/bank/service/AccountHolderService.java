package com.amol.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.bank.entity.AccountHolder;
import com.amol.bank.repo.AccountHolderRepo;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class AccountHolderService {

	@Autowired
	AccountHolderRepo accountHolderRepo;
	
	public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepo.save(accountHolder);
	}

	public AccountHolder getAccountHolder(int accountNumber) {
		return accountHolderRepo.findById(accountNumber).orElse(null);
	}

}
