package com.amol.bank.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {

	@Id
	private int accountNumber = ThreadLocalRandom.current().nextInt(100000, 999999);
	private double balance;

	@OneToOne
	private AccountHolder accountHolder;

//	@Transient
//	Set<Integer> accountNumberSet = new HashSet<>();
//	private void collectAccountNumbers() {
//		accountNumberSet.add(accountNumber);
//		System.out.println(accountNumberSet);
//	}
	
				
//		Set<Integer> set = new Random().ints(-5, 15)
//		  .distinct()
//		  .limit(5)
//		  .boxed()
//		  .collect(Collectors.toSet());

}
