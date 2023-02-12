package com.amol.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amol.bank.entity.AccountHolder;
import com.amol.bank.service.AccountHolderService;

@RestController
public class AccountHolderController {

	@Autowired
	AccountHolderService accountHolderService;
	
	@PostMapping("/addAccountHolder")
	private AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		return accountHolderService.saveAccountHolder(accountHolder);
	}
	
	@GetMapping("getAccountHolder/{uid}")
	private AccountHolder getAccountHolder(@PathVariable long uid) {
		return accountHolderService.getAccountHolder(uid);
	}
	
	
	
}
