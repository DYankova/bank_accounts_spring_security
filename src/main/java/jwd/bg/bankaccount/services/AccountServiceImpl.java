package jwd.bg.bankaccount.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jwd.bg.bankaccount.entities.Account;

@Service
public class AccountServiceImpl implements AccountService {

	private static List<Account> accounts = new ArrayList<Account>();

	@Override
	public boolean newAccount(Account account) {
		return accounts.add(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public Account updateAccount(Account account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).equals(account)) {
				accounts.set(i, account);
				return account;
			}
		}
		return null;
	}

	@Override
	public List<Account> deleteAccount(Account account) {//
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).equals(account)) {
				accounts.remove(i);
				return accounts;
			}
		}
		return null;
	}

	@Override
	public Account findAccount(String accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
				return accounts.get(i);
			}
		}
		return null;
	}
}