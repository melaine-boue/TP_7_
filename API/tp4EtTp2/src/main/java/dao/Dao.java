package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * La classe qui contient l'EntityManager
 * @author Melaine BOUE & Seynabou SARR
 *
 */
public class Dao {
	EntityManagerFactory factory ;           
    EntityManager manager;
    /**
     * Constructeur
     */
	public Dao() {
		
	} 
      
	/**
	 * Retourne l'entity mananger.
	 * @return manager
	 */
	public EntityManager getManager() {
		
		if(this.manager==null)
		{
			this.factory = Persistence.createEntityManagerFactory("dev");
			this.manager =  factory.createEntityManager();
		}
		
		return manager;
	}
	
	/**
	 * Ferme la connexion.
	 */
	public void close() {
		manager.close();
		factory.close();
	}
}

