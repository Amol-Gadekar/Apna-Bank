package com.amol.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.amol.bank.entity.AccountDetails;
import com.amol.bank.entity.Transaction;
import com.amol.bank.repo.AccountDetailsRepo;
import com.amol.bank.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	AccountDetailsRepo accountDetailsRepo;

	AccountDetails accountDetails;

	public AccountDetails depositeAmount(int toAccountNumber, double amount) {
		AccountDetails acDetails = accountDetailsRepo.findById(toAccountNumber).get();
		double oldBalance = acDetails.getBalance();
		double balance = oldBalance + amount;
		acDetails.setBalance(balance);
		return accountDetailsRepo.save(acDetails);
	}

	public AccountDetails withdrawAmount(int fromAccountNumber, double amount) throws Exception {
		AccountDetails acDetails = accountDetailsRepo.findById(fromAccountNumber).get();
		double oldBalance = acDetails.getBalance();
		try {
			if (oldBalance >= amount) {
				double balance = oldBalance - amount;
				acDetails.setBalance(balance);
				return accountDetailsRepo.save(acDetails);
			}
		} catch (Exception e) {
			throw new Exception("Insufficient balance: " + oldBalance + " in Account;" + fromAccountNumber);
		}
		return acDetails;

	}

	public Transaction transfer(Transaction transaction, int fromAccountNumber, int toAccountNumber, double amount)
			throws Exception {
		AccountDetails acDetailsFrom = accountDetailsRepo.findById(fromAccountNumber).get();
		AccountDetails acDetailsTo = accountDetailsRepo.findById(toAccountNumber).get();
		double oldBalanceFrom = acDetailsFrom.getBalance();
		double oldBalanceTo = acDetailsTo.getBalance();

		if (oldBalanceFrom >= amount) {
			double balanceFrom = oldBalanceFrom - amount;
			double balanceTo = oldBalanceTo + amount;
			acDetailsFrom.setBalance(balanceFrom);
			acDetailsTo.setBalance(balanceTo);
			transaction.setAmount(amount);
			transaction.setFromAccountNumber(fromAccountNumber);
			transaction.setToAccountNumber(toAccountNumber);
			return transactionRepo.save(transaction);

		} else
			throw new Exception("Insufficient balance: " + oldBalanceFrom + " in Account;" + fromAccountNumber);

	}

//		currentBalance = currentBalance + amount;
//		accountDetails.setBalance(currentBalance);
//		accountDetails.balance(accountDetails.getAccountNumber(accountNumber)) = currentBalnce

//		int tempAcNum = accountNumber;
//		if (tempAcNum == accountDetailsRepo.findById(accountNumber)) {
//		}
//		int acNumber = accountDetailsRepo.getById(null);
//		if (accountNumber == null) {
//		} else {
//		} 
//		accountNumber = accountDetailsRepo.fin

//	public Transaction withdrawAmount(int accountNumber, double amount) {
//		return null;
//	}

}
