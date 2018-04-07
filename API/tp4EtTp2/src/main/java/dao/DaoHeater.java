package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;
/**
 * La classe DaoHeater
 * @author Melaine BOUE & Seynabou SARR
 *
 */
public class DaoHeater {

	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;
    /**
     * Constructeur
     */
	public DaoHeater() {
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
	 * Crée une Heater dans la base de données
	 */
	public void createHeater(Heater h){
		transaction.begin();
		manager.persist(h);
		transaction.commit();
	}

	/**
	 * Afficher les données relatives à toutes les Heaters
	 */
    public void showHeaters() {
        List<Heater> resultList = manager.createQuery("Select a From Heater a", Heater.class).getResultList();

        for (Heater heater : resultList) {
            System.out.println(heater.toString());
        }
    }

    /**
     * Reccupère la liste des Heaters de la base de données
     * @return la liste des Heaters
     */
   public List<Heater> getHeaters() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Heater> criteriaQuery = criteriaBuilder.createQuery(Heater.class);
		Root<Heater> from = criteriaQuery.from(Heater.class);
		criteriaQuery.select(from);
		TypedQuery<Heater> query = manager.createQuery(criteriaQuery);
		List<Heater> heaters = query.getResultList();

		return heaters;
   }


   /**
    * Recherche une Heater ayant pour identifiant id
    * @param id : identification de la Heater à reccuperer
    * @return la Heater ayant pour identifiant id
    */
   public Heater getHeater(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Heater.class, identifiant);

   }

   /**
    * Mis à jour la Heater dans la base de données
    * @param heater : nouvelle données
    */
   public void update(Heater heater)
   {
	   manager.merge(heater);
   }



   /**
    * Supprime le Heater Heater
    * @param heater : Heater à supprimer
    */
	public void delete(Heater heater)
	{
	   manager.remove(heater);
	}
}

