package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.TransactionController;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import com.worldline.fpl.recruitment.service.TransactionService;

/**
 * Implementation of {@link TransactionController}.
 *
 * @author A525125
 */
@Slf4j
@RestController
public class TransactionControllerImpl implements TransactionController {

	/** The Constant log. */
	private final static Logger log = LoggerFactory.getLogger(TransactionControllerImpl.class);
	
	/** The transaction service. */
	private TransactionService transactionService;
	

	/**
	 * Instantiates a new transaction controller impl.
	 *
	 * @param transactionService the transaction service
	 */
	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/* (non-Javadoc)
	 * @see com.worldline.fpl.recruitment.controller.TransactionController#getTransactionsByAccount(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@PathVariable("accountId") String accountId,
			@PageableDefault Pageable p) {
		Page<TransactionResponse> page = transactionService
				.getTransactionsByAccount(accountId, p);
		if (null == page || page.getTotalElements() == 0) {
			log.debug("Cannot find transaction for account {}", accountId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(page);
	}

	/* (non-Javadoc)
	 * @see com.worldline.fpl.recruitment.controller.TransactionController#deleteTransactionsByAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public ResponseEntity<Void> deleteTransactionsByAccount(@PathVariable("accountId")String accountId, 
			@PathVariable("transactionId")String transactionId) {
		  transactionService.deleteTransactionByAccount(accountId, transactionId);
		return ResponseEntity.ok().body(null);
	}


	/**
	 * Adds the transactions by account.
	 *
	 * @param accountId the account id
	 * @param transaction the transaction
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<TransactionResponse> addTransactionsByAccount(@PathVariable("accountId")String accountId,
			@RequestBody Transaction transaction) {
		
		TransactionResponse result = transactionService.addTransaction(accountId, transaction);
		return new ResponseEntity<TransactionResponse>(result, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TransactionResponse> updateTransactionsByAccount(@PathVariable("accountId")String accountId, 
			@PathVariable("transactionId")String transactionId,
			@RequestBody Transaction transaction) {
		
		TransactionResponse result = transactionService.updateTransaction(accountId, transaction,transactionId);
		return new ResponseEntity<TransactionResponse>(result, HttpStatus.NO_CONTENT);
	}
	


}
