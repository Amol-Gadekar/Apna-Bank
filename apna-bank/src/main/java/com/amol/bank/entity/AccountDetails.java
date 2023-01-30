package com.amol.bank.entity;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class AccountDetails {

	@Id
	private int accountNumber=ThreadLocalRandom.current().nextInt(220000,229999);
	private double balance;
	
	@OneToOne
	private AccountHolder accountHolder;
}
