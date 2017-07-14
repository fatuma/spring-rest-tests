package com.worldline.fpl.recruitment.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.worldline.fpl.recruitment.dao.AccountRepository;
import com.worldline.fpl.recruitment.entity.Account;

/**
 * Implementation of {@link AccountRepository}.
 *
 * @author A525125
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository,
		InitializingBean {

	/** The accounts. */
	private List<Account> accounts;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		accounts = new ArrayList<>();

		{
			Account account = new Account();
			account.setId("1");
			account.setCreationDate(new Date());
			account.setActive(true);
			account.setType("SAVING");
			account.setNumber("01000251215");
			account.setBalance(BigDecimal.valueOf(4210.42));
			accounts.add(account);
		}
		{
			Account account = new Account();
			account.setId("2");
			account.setCreationDate(new Date());
			account.setActive(false);
			account.setType("CURRENT");
			account.setNumber("01000251216");
			account.setBalance(BigDecimal.valueOf(25.12));
			accounts.add(account);
		}

	}

	/* (non-Javadoc)
	 * @see com.worldline.fpl.recruitment.dao.AccountRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Account> findAll(Pageable p) {
		return new PageImpl<Account>(accounts);
	}

	/* (non-Javadoc)
	 * @see com.worldline.fpl.recruitment.dao.AccountRepository#findById(java.lang.String)
	 */
	@Override
	public Optional<Account> findById(String accountId) {
		return accounts.stream().filter(a -> a.getId().equals(accountId))
				.findFirst();
	}

	/* (non-Javadoc)
	 * @see com.worldline.fpl.recruitment.dao.AccountRepository#exists(java.lang.String)
	 */
	@Override
	public boolean exists(String accountId) {
		return accounts.stream().anyMatch(a -> a.getId().equals(accountId));
	}
}
