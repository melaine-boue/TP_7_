package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;
/**
 *
 * @author Melaine
 *
 */
public class DaoPerson {

	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;

	/**
	 * Constructeur
	 */
	public DaoPerson() {
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
	 * Crée une personne dans la base de données
	 * @param p : Personne à ajouer dans la base de donnééz
	 */
	public void createPerson(Person p){
		transaction.begin();
		manager.persist(p);

		transaction.commit();
		System.out.println("Insertion "+p.getId());
	}

	/**
	 * Afficher les données relatives à toutes les personnes
	 */
    public void showPersons() {
        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        for (Person Person : resultList) {
            System.out.println(Person.toString());
        }
    }

    /**
     * Reccupère la liste des personnes de la base de données
     * @return la liste des personnes
     */
   public List<Person> getPersons() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> from = criteriaQuery.from(Person.class);
		criteriaQuery.select(from);
		TypedQuery<Person> query = manager.createQuery(criteriaQuery);
		List<Person> persons = query.getResultList();

		return persons;
   }


   /**
    * Recherche une personne ayant pour identifiant id
    * @param id : identification de la personne à reccuperer
    * @return la personne ayant pour identifiant id
    */
   public Person getPerson(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Person.class, identifiant);

   }

   /**
    * Mis à jour la personne person dans la base de données
    * @param person : nouvelle données
    */
   public void update(Person person)
   {
	   transaction.begin();
	   //manager.merge(person);

	   transaction.commit();
   }



   /**
    * Supprime la personne person
    * @param person : personne à supprimer
    */
	public void delete(Person person)
	{
		transaction.begin();
	   manager.remove(person);
	   transaction.commit();
	}
}

