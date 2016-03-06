package jwd.bg.bankaccount.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jwd.bg.bankaccount.entities.ExchangeRate;
import jwd.bg.bankaccount.entities.Account;

@Service
public class OperationServiceImpl implements OperationService {
	private static final Map<String, ExchangeRate> exchangeRates = new HashMap<String, ExchangeRate>();

	@Autowired
	@Qualifier("AccountServiceImpl")
	private AccountService accountService;

	static {
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.setCurrency("BGN");
		exchangeRate.setRate(1.95);
		exchangeRate.setDate(new Date());
		exchangeRates.put("EUR", exchangeRate);
	}

	@Override
	public double deposit(String accountNumber, double amount, String currency) {
		Account account = accountService.findAccount(accountNumber);
		
		if (account != null) {
			if (!account.getAccountCurrency().equals(currency)) {
				ExchangeRate exchangeRate = exchangeRates.get(currency);
				amount *= exchangeRate.getRate();
			}
				double currentAmount = account.getAmount();
				currentAmount += amount;
				account.setAmount(currentAmount);
				accountService.updateAccount(account);
				return currentAmount;
		}
		return 0;
	}

	@Override
	public double withdraw(String accountNumber, double amount, String currency) {
		Account account = accountService.findAccount(accountNumber);
		if (account != null) {
			if (!account.getAccountCurrency().equals(currency)) {
				ExchangeRate exchangeRate = exchangeRates.get(currency);
				amount *= exchangeRate.getRate();
			}
			double currentAmount = account.getAmount();
			if (currentAmount >= amount) {
				account.setAmount(currentAmount - amount);
				accountService.updateAccount(account);
				return account.getAmount();
			}
		}
		return 0;
	}
}
