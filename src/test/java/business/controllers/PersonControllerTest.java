package business.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.PersonWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.PersonDao;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class PersonControllerTest {
	@Autowired
	PersonController personController;
	
	@Autowired
	PersonDao personDao;
	@Test
	public void getPersonTest(){
		PersonWrapper person = personController.getPerson(1);
		assertEquals(personDao.findById(1).getName(), person.getName());
	}
	@Test
	public void createPersonTest(){
		int numPersons = personDao.findAll().size();
		Person person = new Person("NName", "NCountry", "NDate");
		personController.createPerson(new PersonWrapper(person));
		assertEquals(numPersons+1, personDao.findAll().size());
	}
	
	@Test
	public void showPersonsTest(){
		int numPersons = personDao.findAll().size();
		assertEquals(numPersons, personController.showPersons().size());
	}

	@Test
	public void deletePersonTest(){
		int aux = personDao.findAll().size();
		personController.deletePerson(4);
		assertEquals(aux-1, personDao.findAll().size());
	}
	
	@Test
	public void updatePersonTest(){
		Person person = personDao.findById(2);
		person.setName("new name");
		PersonWrapper personWrapper = new PersonWrapper(person);
		personController.updatePerson(2, personWrapper);
		assertTrue(personDao.findById(2).getName().equals("new name"));
	}
}
