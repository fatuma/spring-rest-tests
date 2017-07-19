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
	 * @param accountService
	 *            the account service
	 * @param transactionRepository
	 *            the transaction repository
	 */
	@Autowired
	public TransactionService(AccountService accountService, TransactionRepository transactionRepository) {
		this.accountService = accountService;
		this.transactionRepository = transactionRepository;
	}

	/**
	 * Get transactions by account.
	 *
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable object
	 * @return the transactions by account
	 */
	public Page<TransactionResponse> getTransactionsByAccount(String accountId, Pageable p) {
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "Account doesn't exist");
		}
		return new PageImpl<TransactionResponse>(transactionRepository.getTransactionsByAccount(accountId, p)
				.getContent().stream().map(this::map).collect(Collectors.toList()));
	}

	/**
	 * Map {@link Transaction} to {@link TransactionResponse}.
	 *
	 * @param transaction
	 *            the transaction
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
	 * @param accountId
	 *            the account id
	 * @param transactionId
	 *            the transaction id
	 */
	public void deleteTransactionByAccount(String accountId, String transactionId) {
		Transaction transaction = new Transaction();
		// check if account exist
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");
		}
		// check if transaction exist and belong to the account
		if (!transactionRepository.exists(transactionId)) {

			throw new ServiceException(ErrorCode.INVALID_TRANSACTION, "the transaction doesnt exist");
		} else {

			transaction = transactionRepository.findOne(transactionId);
		}

		if (!accountId.equals(transaction.getAccount().getId())) {
			throw new ServiceException(ErrorCode.INVALID_TRANSACTION_FOR_ACCOUNT,
					"the transaction doesnt belong to the account");
		}

		transactionRepository.delete(transactionId);
		;

	}

	/**
	 * Adds the transaction.
	 *
	 * @param accountId
	 *            the account id
	 * @param transaction
	 *            the transaction
	 * @return the transaction response
	 */
	public TransactionResponse addTransaction(String accountId, Transaction transaction) {
		TransactionResponse response = new TransactionResponse();
		if (transaction.getBalance() == null) {
			throw new ServiceException(ErrorCode.EMPTY_BALANCE, "balance must not be null");

		}
		if (transaction.getNumber() == null) {

			throw new ServiceException(ErrorCode.EMPTY_Number, "Number must not be null");
		}
		// check if account exist
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");

			// call the repo to add the transaction
		} else {
			// transaction.setAccount(accountService.getAccountDetails(accountId));;
			response = this.map(transactionRepository.save(transaction));
		}
		return response;
	}

	/**
	 * Update transaction.
	 *
	 * @param accountId
	 *            the account id
	 * @param transaction
	 *            the transaction
	 * @param transactionId
	 *            the transaction id
	 * @return the transaction response
	 */
	public TransactionResponse updateTransaction(String accountId, Transaction transaction, String transactionId) {
		if (transaction.getBalance() == null) {
			throw new ServiceException(ErrorCode.EMPTY_BALANCE, "balance must not be null");

		}
		if (transaction.getNumber() == null) {

			throw new ServiceException(ErrorCode.EMPTY_Number, "Number must not be null");
		}
		try {
			Transaction transactionToUpdate = transactionRepository.findOne(transactionId);

			// check if account exist
			if (!accountService.isAccountExist(accountId)) {
				throw new ServiceException(ErrorCode.INVALID_ACCOUNT, "the account doesnt exist");
			}
			if (accountId.equals(transactionToUpdate.getAccount().getId())) {
				throw new ServiceException(ErrorCode.INVALID_TRANSACTION_FOR_ACCOUNT,
						"the transaction doesnt belong to the account");

			}
			transactionToUpdate.setBalance(transaction.getBalance());
			transactionToUpdate.setNumber(transaction.getNumber());

			return this.map(transactionRepository.save(transactionToUpdate));

		} catch (Exception e) {
			throw new ServiceException(ErrorCode.INVALID_TRANSACTION, "the transaction doesnt exist");
		}

	}

}
