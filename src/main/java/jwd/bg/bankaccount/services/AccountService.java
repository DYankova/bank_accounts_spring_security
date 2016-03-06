package jwd.bg.bankaccount.services;

import java.util.List;
import jwd.bg.bankaccount.entities.Account;

public interface AccountService {
	boolean newAccount(Account account);

	List<Account> getAccounts();

	Account updateAccount(Account account);

	List<Account> deleteAccount(Account account);
	
	Account findAccount(String accountNumber);
}
