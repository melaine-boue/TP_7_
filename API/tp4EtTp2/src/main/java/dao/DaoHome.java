package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;
/**
 * La classe DaoHome
 * @author Melaine BOUE & SARR Seynabou
 *
 */
public class DaoHome {

	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;
    /**
     * Constructeur
     */
	public DaoHome() {
		managerObject = new Dao();
		manager = managerObject.getManager();
		transaction = manager.getTransaction();
	}



	/**
	 * Ferme la connexion
	 */
	public void close() {
		managerObject.close();
		manager.close();
	}

	/************************CRUD*************************/

	/**
	 * Cr�e une Home dans la base de donn�es
	 * @param h : element � inserer
	 */
	public void createHome(Home h){
		transaction.begin();
		manager.persist(h);
		transaction.commit();
	}

	/**
	 * Afficher les donn�es relatives � toutes les Homes
	 */
    public void showHomes() {
        List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();

        for (Home home : resultList) {
            System.out.println(home.toString());
        }
    }

    /**
     * Reccup�re la liste des Homes de la base de donn�es
     * @return la liste des Homes
     */
   public List<Home> getHomes() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Home> criteriaQuery = criteriaBuilder.createQuery(Home.class);
		Root<Home> from = criteriaQuery.from(Home.class);
		criteriaQuery.select(from);
		TypedQuery<Home> query = manager.createQuery(criteriaQuery);
		List<Home> homes = query.getResultList();

		return homes;
   }


   /**
    * Recherche une Home ayant pour identifiant id
    * @param id : identification de la Home � reccuperer
    * @return la Home ayant pour identifiant id
    */
   public Home getHome(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Home.class, identifiant);

   }

   /**
    * Mis � jour la Home dans la base de donn�es
    * @param home : nouvelle donn�es
    */
   public void update(Home home)
   {
	   manager.merge(home);
   }



   /**
    * Supprime la Home home
    * @param home : Home � supprimer
    */
	public void delete(Home home)
	{
	   manager.remove(home);
	}
}

