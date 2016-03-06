package jwd.bg.bankaccount.services;

public interface OperationService {
	
	double withdraw(String accountNumber, double amount,String currency);

	double deposit(String accountNumber, double amount, String currency);
}
