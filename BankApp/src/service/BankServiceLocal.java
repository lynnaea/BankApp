package service;

import javax.ejb.Local;

import entity.Account;
import entity.Client;

@Local
public interface BankServiceLocal {

	public abstract void transfer(int fromAccountId, int toAccountId, double amount)
			throws BankException;

	public abstract void createAccountForClient(Account account, int clientid)
			throws BankException;

	public abstract void createClient(Client client);

}
