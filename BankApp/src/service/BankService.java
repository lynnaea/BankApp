package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dal.ClientFacade;
import entity.Account;
import entity.Client;

/**
 * Session Bean implementation class BankService
 */
@Stateless
public class BankService implements BankServiceLocal {
	
	@EJB
	ClientFacade clientFacade;
	
	

    /**
     * Default constructor. 
     */
    public BankService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void createClient(Client client) {
    	clientFacade.create(client);
    }
    
    @Override
	public void createAccountForClient(Account account, int clientid) throws BankException{
    	
    }
    
    
    @Override
	public void transfer(int fromAccountId, int toAccountId, double amount) throws BankException {
    	
    }
}
