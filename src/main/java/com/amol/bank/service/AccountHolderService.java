package com.amol.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.bank.customexception.UserAlreadyExistException;
import com.amol.bank.entity.AccountHolder;
import com.amol.bank.repo.AccountHolderRepo;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class AccountHolderService {

	@Autowired
	AccountHolderRepo accountHolderRepo;
	
//	public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
//		return accountHolderRepo.save(accountHolder);
//	}
	public AccountHolder saveAccountHolder(AccountHolder accountHolder) throws Exception {
		
		String email = accountHolder.getEmail();
		long phoneNumber = accountHolder.getPhoneNumber();
		
		if (accountHolderRepo.existsByEmail(email)==true) {
			throw new UserAlreadyExistException("Email already exists");
		}else if (accountHolderRepo.existsByPhoneNumber(phoneNumber)==true) {
			throw new UserAlreadyExistException("Phone Number already exists");
		}
		
		System.out.println("Exception Handled");
		return accountHolderRepo.save(accountHolder);
	}

	public AccountHolder getAccountHolder(long uid) {
		return accountHolderRepo.findById(uid).orElse(null);
	}

}
