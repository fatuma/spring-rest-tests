package com.worldline.fpl.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Transaction repository.
 *
 * @author A525125
 */
public interface TransactionRepository {

	/**
	 * Get transactions by account.
	 *
	 * @param accountId            the account id
	 * @param p            the pageable information
	 * @return the transactions by account
	 */
	Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);
    
    /**
     * Delete transaction by account.
     *
     * @param accountId the account id
     * @param transactionId the transaction id
     */
    public void deleteTransactionByAccount(String accountId,String transactionId);
    
    /**
     * Exist.
     *
     * @param transactionId the transaction id
     * @return true, if successful
     */
    public boolean exist(String transactionId);
    
    /**
     * Checks if is transaction for account.
     *
     * @param transactionId the transaction id
     * @param accountId the account id
     * @return true, if is transaction for account
     */
    public boolean isTransactionForAccount(String transactionId,String accountId);
    
    /**
     * Adds the transaction.
     *
     * @param transaction the transaction
     * @return the transaction
     */
    public Transaction add(Transaction transaction);
    
    /**
     * Update.
     *
     * @param transaction the transaction
     * @return the transaction
     */
    public Transaction update(Transaction transaction);
}
