package fr.istic.sir.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;
@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
     
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setName("toto");
        Heater h1 = new Heater();
        h1.setPower("500w");
        Heater h2 = new Heater();
        h2.setPower("600w");
        h.addDevices(h1);
        h.addDevices(h2);
        return h;
    }
    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        Person p = new Person();
        p.setNom("Mariama");
        p.setPrenom("Ndiaye");
        p.setAge(new Long(20));
        p.setMail("MariamaNdiaye@yahoo.fr");
        List<Home> homes= new ArrayList <Home>();
        Home home=new Home();
        home.setName("toto");
        home.setNbrePieces(2);
        home.setTaille(125);
        Heater h1 = new Heater();
        h1.setPower("500w");
        Heater h2 = new Heater();
        h2.setPower("600w");
        home.addDevices(h1);
        home.addDevices(h2);
        homes.add(home);
        p.setHomes(homes);
        List<ElectronicDevice> electronicDevices= new ArrayList<ElectronicDevice>();
        ElectronicDevice electronicDevice1= new ElectronicDevice();
        electronicDevice1.setConsMoyenne(4845312);
        electronicDevice1.setPower("900");
        electronicDevices.add(electronicDevice1);
        ElectronicDevice electronicDevice2= new ElectronicDevice();
        electronicDevice1.setConsMoyenne(65354215);
        electronicDevice1.setPower("800");
        electronicDevices.add(electronicDevice2);
        p.setElectronicDevices(electronicDevices);
        return p;
    }
}

