package com.worldline.fpl.recruitment.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;
import com.worldline.fpl.recruitment.json.TransactionResponse;

/**
 * Transaction service.
 *
 * @author A525125
 */
@Service
public class TransactionService {

	/** The account service. */
	private AccountService accountService;

	/** The transaction repository. */
	private TransactionRepository transactionRepository;

	/**
	 * Instantiates a new transaction service.
	 *
	 * @param accountService the account service
	 * @param transactionRepository the transaction repository
	 */
	@Autowired
	public TransactionService(AccountService accountService,
			TransactionRepository transactionRepository) {
		this.accountService = accountService;
		this.transactionRepository = transactionRepository;
	}

	/**
	 * Get transactions by account.
	 *
	 * @param accountId            the account id
	 * @param p            the pageable object
	 * @return the transactions by account
	 */
	public Page<TransactionResponse> getTransactionsByAccount(String accountId,
			Pageable p) {
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT,
					"Account doesn't exist");
		}
		return new PageImpl<TransactionResponse>(transactionRepository
				.getTransactionsByAccount(accountId, p).getContent().stream()
				.map(this::map).collect(Collectors.toList()));
	}

	/**
	 * Map {@link Transaction} to {@link TransactionResponse}.
	 *
	 * @param transaction the transaction
	 * @return the transaction response
	 */
	private TransactionResponse map(Transaction transaction) {
		TransactionResponse result = new TransactionResponse();
		result.setBalance(transaction.getBalance());
		result.setId(transaction.getId());
		result.setNumber(transaction.getNumber());
		return result;
	}
	
	/**
	 * Delete transaction by account.
	 *
	 * @param accountId the account id
	 * @param transactionId the transaction id
	 */
	public void deleteTransactionByAccount(String accountId,String transactionId){
		//check if account exist
		if(!accountService.isAccountExist(accountId)){
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");
		}
		//check if transaction exist and belong to the account
		if(!transactionRepository.exist(transactionId)){
			throw new ServiceException(ErrorCode.INVALID_TRANSACTION, "the transaction doesnt exist");
		}
		if(!transactionRepository.isTransactionForAccount(transactionId, accountId)){
			throw new ServiceException(ErrorCode.INVALID_TRANSACTION_FOR_ACCOUNT, "the transaction doesnt belong to the account");
		}
		
		transactionRepository.deleteTransactionByAccount(accountId, transactionId);
		
		
	}
	
	/**
	 * Adds the transaction.
	 *
	 * @param accountId the account id
	 * @param transaction the transaction
	 * @return the transaction response
	 */
	public TransactionResponse addTransaction(String accountId,Transaction transaction){
		TransactionResponse response= new TransactionResponse();
		if(transaction.getBalance() == null){
			throw new ServiceException(ErrorCode.EMPTY_BALANCE, "balance must not be null");
			
		}if(transaction.getNumber() == null){

			throw new ServiceException(ErrorCode.EMPTY_Number, "Number must not be null");
		}
		//check if account exist
		if(!accountService.isAccountExist(accountId)){
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");
		
		//call the repo to add the transaction 
		}else{
			transaction.setAccountId(accountId);
			response=this.map(transactionRepository.add(transaction));
		}
		return response;
	}

	public TransactionResponse updateTransaction(String accountId, Transaction transaction,String transactionId) {
		if(transaction.getBalance() == null){
			throw new ServiceException(ErrorCode.EMPTY_BALANCE, "balance must not be null");
			
		}if(transaction.getNumber() == null){

			throw new ServiceException(ErrorCode.EMPTY_Number, "Number must not be null");
		}
		//check if account exist
			if(!accountService.isAccountExist(accountId)){
					throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");
				}
	   //check if transaction exist and belong to the account
			if(!transactionRepository.exist(transactionId)){
					throw new ServiceException(ErrorCode.INVALID_TRANSACTION, "the transaction doesnt exist");
				}
			if(!transactionRepository.isTransactionForAccount(transactionId, accountId)){
					throw new ServiceException(ErrorCode.INVALID_TRANSACTION_FOR_ACCOUNT, "the transaction doesnt belong to the account");
				}
				transaction.setAccountId(accountId);
				transaction.setId(transactionId);
		return this.map(transactionRepository.update(transaction));
	}


}
