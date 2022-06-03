package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.entity.LoanAccount;

/**
 * @author Kenb.vilgax
 *
 */
@Repository
public interface LoanAccountRepo extends JpaRepository<LoanAccount, Integer> {
	
	public LoanAccount findByloanAccountId(Integer id);
}
