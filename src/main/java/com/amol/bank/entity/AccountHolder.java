package com.amol.bank.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDeleteAll;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dob;
	private long phoneNumber;
	private String password;
	
	@OneToOne(mappedBy = "accountHolder")
	@JsonBackReference
	private AccountDetails accountDetails;
	
	
	
}
