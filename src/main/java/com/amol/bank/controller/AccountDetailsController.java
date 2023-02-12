package com.amol.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amol.bank.entity.AccountDetails;
import com.amol.bank.entity.AccountHolder;
import com.amol.bank.service.AccountDetailsService;

@RestController
public class AccountDetailsController {
	
	@Autowired
	AccountDetailsService accountDetailsService;
	
	AccountDetails accountDetails; 
	
	@PostMapping("/addAccountDetails")
	private AccountDetails addAccountDetails(@RequestBody AccountDetails accountDetails) {
		return accountDetailsService.addAccountDetails(accountDetails);
	}
	
//	private void printAccountNumbers() {
//		accountDetails.
//	}
	
	@GetMapping("getAccountDetails/{accountNumber}")
	private AccountDetails getAccountDetails(@PathVariable int accountNumber) {
		return accountDetailsService.getAccountDetails(accountNumber);
	}
}
