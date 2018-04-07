package domain;

import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	
	        long id;
			String nom ;
			String prenom;
			Long age;
			String mail;
			Collection<Person> friends;
			Collection<Home> homes;
			Collection<ElectronicDevice> electronicDevices;
			
			public Person() {
			}
			
			public Person(String nom, String prenom,long age) {
				this.nom = nom;
				this.prenom = prenom;
				this.age = age;
			}
			
			public Person(String nom, String prenom, String mail, Collection<Person> friends, Collection<Home> homes,
					Collection<ElectronicDevice> electronicDevices) {
				this.nom = nom;
				this.prenom = prenom;
				this.mail = mail;
				this.friends = friends;
				this.homes = homes;
				this.electronicDevices = electronicDevices;
			}
            @Id
            @GeneratedValue
			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getNom() {
				return nom;
			}

			public void setNom(String nom) {
				this.nom = nom;
			}

			public String getMail() {
				return mail;
			}

			public void setMail(String mail) {
				this.mail = mail;
			}
			
            @OneToMany
            @JoinColumn(name="friends_id")
            public Collection<Person> getFriends() {
				return friends;
			}

			public void setFriends(Collection<Person> friends) {
				this.friends = friends;
			}

			@OneToMany
            @JoinColumn(name="person_id")
			public Collection<Home> getHomes() {
				return homes;
			}

			public String getPrenom() {
				return prenom;
			}

			public void setPrenom(String prenom) {
				this.prenom = prenom;
			}

			
			@Column(name="ageperson")
			public Long getAge() {
				return age;
			}
			public void setAge(Long age) {
				this.age = age;
			}
			public void setHomes(Collection<Home> homes) {
				this.homes = homes;
			}
            @OneToMany
            @JoinColumn(name="person_id")
			public Collection<ElectronicDevice> getElectronicDevices() {
				return electronicDevices;
			}

			public void setElectronicDevices(Collection<ElectronicDevice> electronicDevices) {
				this.electronicDevices = electronicDevices;
			}
			
			
			
		}
