package com.amol.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amol.bank.entity.AccountHolder;

@Repository
public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long>{

}
