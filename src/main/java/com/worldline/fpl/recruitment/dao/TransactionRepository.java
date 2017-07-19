package com.worldline.fpl.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.worldline.fpl.recruitment.entity.Transaction;

// TODO: Auto-generated Javadoc
/**
 * Transaction repository.
 *
 * @author 
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
	
	  /** The get transaction by account. */
  	public static String GET_TRANSACTION_BY_ACCOUNT = "select transaction from Transaction transaction where transaction.account.id=?1";

	    /**
    	 * Gets the transactions by account.
    	 *
    	 * @param accountId the account id
    	 * @param p the p
    	 * @return the transactions by account
    	 */
    	@Query(GET_TRANSACTION_BY_ACCOUNT)
	    public Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);
	

}
