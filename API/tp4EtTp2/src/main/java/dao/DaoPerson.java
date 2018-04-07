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
	 * Cr�e une personne dans la base de donn�es
	 * @param p : Personne � ajouer dans la base de donn��z
	 */
	public void createPerson(Person p){
		transaction.begin();
		manager.persist(p);

		transaction.commit();
		System.out.println("Insertion "+p.getId());
	}

	/**
	 * Afficher les donn�es relatives � toutes les personnes
	 */
    public void showPersons() {
        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        for (Person Person : resultList) {
            System.out.println(Person.toString());
        }
    }

    /**
     * Reccup�re la liste des personnes de la base de donn�es
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
    * @param id : identification de la personne � reccuperer
    * @return la personne ayant pour identifiant id
    */
   public Person getPerson(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Person.class, identifiant);

   }

   /**
    * Mis � jour la personne person dans la base de donn�es
    * @param person : nouvelle donn�es
    */
   public void update(Person person)
   {
	   transaction.begin();
	   //manager.merge(person);

	   transaction.commit();
   }



   /**
    * Supprime la personne person
    * @param person : personne � supprimer
    */
	public void delete(Person person)
	{
		transaction.begin();
	   manager.remove(person);
	   transaction.commit();
	}
}

