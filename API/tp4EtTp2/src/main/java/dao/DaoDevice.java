package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoDevice {
	
	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;
    
	public DaoDevice() {
		managerObject = new Dao();
		manager = managerObject.getManager();
		transaction = manager.getTransaction();
	} 
      
	
    
	
	public void close() {
		managerObject.close();
		manager.close();
	}
	
	
	
	/************************CRUD*************************/
	
	/**
	 * Cr�e une Device dans la base de donn�es
	 * @param d: element � inserer
	 */
	public void createDevice(Device d){
		transaction.begin();
		manager.persist(d);
		transaction.commit();
	}
	
	/**
	 * Afficher les donn�es relatives � toutes les Devices
	 */
    public void showDevices() {
        List<Device> resultList = manager.createQuery("Select a From Device a", Device.class).getResultList();
        
        for (Device Device : resultList) {
            System.out.println(Device.toString());
        }
    }
    
    /**
     * Reccup�re la liste des Devices de la base de donn�es
     * @return la liste des Devices
     */
   public List<Device> getDevices() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
		Root<Device> from = criteriaQuery.from(Device.class);
		criteriaQuery.select(from);
		TypedQuery<Device> query = manager.createQuery(criteriaQuery);
		List<Device> Devices = query.getResultList();
		
		return Devices;
   }
   
   
   /**
    * Recherche une Device ayant pour identifiant id
    * @param id : identification de la Device � reccuperer
    * @return la Device ayant pour identifiant id
    */
   public Device getDevice(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Device.class, identifiant);
	   
   }
   
   /**
    * Mis � jour la Device dans la base de donn�es
    * @param Device : nouvelle donn�es
    */
   public void update(Device device)
   {
	   manager.merge(device);
   }



   /**
    * Supprime le Device Device
    * @param Device : Device � supprimer
    */
	public void delete(Device device)
	{
	   manager.remove(device);
	}
}

