package domain;

import java.util.ArrayList;

import java.util.Collection;
import dao.*;

public class Main {

	public static void main(String[] args) {
		
	    DaoPerson personManager = new DaoPerson();
	    DaoHome homeManager = new DaoHome();
	    DaoHeater heaterManager = new DaoHeater();
	    DaoElectronicDevice electronicDeviceManager = new DaoElectronicDevice();
	    
	    
		try {
	        Collection <Heater> heaters=  new ArrayList<Heater>();
			Heater heater= new Heater();
			heaters.add(heater);
			Collection <Home> homes= new ArrayList<Home>();
			Home home = new Home();
			Collection<ElectronicDevice> electronicDevices = new ArrayList <ElectronicDevice>();
			ElectronicDevice ed= new ElectronicDevice();
			electronicDevices.add(ed);
			Collection<Person> persons = new ArrayList <Person> ();
			Person p = new Person("SARR", "Seynabou","13 A rue du Bois Perrin",persons, homes,electronicDevices);
			Collection<Person> pers= new ArrayList<Person>();
			Person person= new Person("BOUE", "MELAINE","BOIS PERRIN", null, null, null);
			
			persons.add(person);
			pers.add(p);
			pers.add(person);
			
			
			heaterManager.createHeater(heater);
			homeManager.createHome(home);
			electronicDeviceManager.createElectronicDevice(ed);
			personManager.createPerson(person);
			personManager.createPerson(p);
			
			person.setNom("Le nom modifié");
			personManager.update(person);
			
			//test.listPerson();
			System.out.println("Nombre de personne avec Criteria :"+personManager.getPersons().size());
			personManager.showPersons();
			
			System.out.println(personManager.getPerson(2).toString());
			//test.DeletePerson(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}	

}
