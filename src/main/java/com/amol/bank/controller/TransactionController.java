package com.amol.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amol.bank.entity.AccountDetails;
import com.amol.bank.entity.Transaction;
import com.amol.bank.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	AccountDetails accountDetails;
	
	@PutMapping("/{toAccountNumber}/deposite/{amount}")
	private AccountDetails depositeAmount(@PathVariable int toAccountNumber, @PathVariable double amount) {
		return transactionService.depositeAmount(toAccountNumber, amount);
	}
	
	@PutMapping("/{fromAccountNumber}/withdraw/{amount}")
	private AccountDetails withdrawAmount(@PathVariable int fromAccountNumber, @PathVariable double amount) throws Exception {
		return transactionService.withdrawAmount(fromAccountNumber, amount);
	}

	@PostMapping("/{fromAccountNumber}/{toAccountNumber}/transfer/{amount}")
	private Transaction transfer(@RequestBody Transaction transaction, @PathVariable int fromAccountNumber, @PathVariable int toAccountNumber, @PathVariable double amount) throws Exception {
		return transactionService.transfer(transaction, fromAccountNumber, toAccountNumber, amount);
	}
}
