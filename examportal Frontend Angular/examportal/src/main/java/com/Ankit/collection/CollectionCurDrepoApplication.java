package com.Ankit.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Ankit.collection.model.person;
import com.Ankit.collection.model.role;
import com.Ankit.collection.model.user;
import com.Ankit.collection.model.usersrole;
import com.Ankit.collection.service.personservice;
import com.Ankit.collection.service.userservice;

@SpringBootApplication
public class CollectionCurDrepoApplication implements CommandLineRunner {
	@Autowired
	private userservice usersviceee;
	

	@Autowired
	private personservice personservicc;
	
	public static void main(String[] args) {
		SpringApplication.run(CollectionCurDrepoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		createPersons();
//		dataenter();
//		getPersonByIds();
		
	}
	
	private void dataenter() throws Exception {
		user users=new user();
		
		users.setFirstName("ankit pazare");
		users.setLastName("riddke");
		users.setUsername("ankitsda");
		users.setPassword("ankit");
		users.setEmail("Ankitpazate@gmial");
		users.setProfile("defauklt.png");
		
		role roles=new role();
		roles.setRoleID(44L);
		roles.setRoleName("admin");
		
		Set<usersrole>usersroles=new HashSet<>();
		
		usersrole usersroless=new usersrole();
		usersroless.setRole(roles);
		usersroless.setUser(users);
		
//		usersroles.add( usersroless);
		usersroles.add(usersroless);
		user user1=this.usersviceee.createusr(users, usersroles);
		System.out.println(user1.getUsername());
	}

	private void createPersons() {

		/*
		 * List<Person> personList=new ArrayList<Person>();
		 * 
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * 
		 * personList.add(new Person("Kiran1", "kumar", "kiran@gmail.com", 20));
		 * 
		 * personList.add(new Person("Kiran2", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran3", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran4", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran5", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran6", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran7", "kumar", "kiran@gmail.com", 20));
		 */

		java.util.List<person> personList = Arrays.asList(
				new person("ankit", "pazare", "ankit@gmail.com", 20),
				new person("Ram", "kumar", "ram@gmail.com", 22),
				new person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new person("KiranKiran", "kumar", "kirannew@gmail.com", 20),
				new person("RamRam", "kumar", "ramnew@gmail.com", 22),
				new person("RamKiranRamKiran", "LaxmiKiran", "sitanew@gmail.com", 30),
				new person("RamKiranRamKiran", "Seth", "sethnee@gmail.com", 50),
				new person("SitaSita", "Kumar", "lakshmannew@gmail.com", 50),
				new person("GaneshSita", "Kumar", "ganeshnew@gmail.com", 50));

		Iterable<person> list = personservicc.saveAllperson(personList);
		for (person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}
	
	
	
	private void getPersonByIds() {
		java.util.List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<person> personsList = personservicc.findperson(personList);
		//select * from tbl_person where person_id in (1,2,12,5,6,20,40,11,15,3,4);
		for (person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

}
