package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.Account;
import com.bank.entity.Customer;

/**
 * @author Kenb.vilgax
 *
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update Customer SET password=:password where email=:email")
	Integer updatePassword(@Param(value = "email") String email, @Param(value = "password") String password);
	
	 @Query("from Account where aid=:cid")
	 Account getAccountByCustomerCid(@Param(value="cid")Integer cid);

	
}
