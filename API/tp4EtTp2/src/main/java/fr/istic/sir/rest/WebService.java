package fr.istic.sir.rest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import dao.DaoHome;
import dao.DaoPerson;
import domain.Home;
import domain.Message;
import domain.Person;

@Path("/opower")
public class WebService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Juste un test du bon fonctionnement";
	}
		
	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersonnes()
	{
		DaoPerson personManager = new DaoPerson();
		return personManager.getPersons();
	}
		
	@GET
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getHomes()
	{
		DaoHome homeManager = new DaoHome();
		return homeManager.getHomes();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person addPerson(Person p) {
		DaoPerson personManager = new DaoPerson();
		personManager.createPerson(p);
		return p;
	}
}
