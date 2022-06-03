package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.entity.Account;

/**
 * @author Kenb.vilgax
 *
 */
public interface AccountRepo extends JpaRepository<Account, Integer>
{
	
	Account getAccountByaccountNo(String accno);
}
