package dal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Client;

/**
 * Session Bean implementation class ClientFacade
 */
@Stateless
@LocalBean
public class ClientFacade extends AbstractFacade<Client> {

	@PersistenceContext
    private EntityManager em;

	/**
     * Default constructor. 
     */
    public ClientFacade() {

    	super(Client.class);
    }
       

	@Override
	protected EntityManager em() {
		return em;
	}

}
