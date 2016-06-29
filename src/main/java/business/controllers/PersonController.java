package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.PersonWrapper;
import data.daos.PersonDao;
import data.entities.Person;

@Controller
public class PersonController {
	private PersonDao personDao;
	@Autowired
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
	public boolean createPerson(PersonWrapper personWrapper){
		Person person = new Person();
		person.setBirthdate(personWrapper.getBirthdate());
		person.setName(personWrapper.getName());
		person.setNationality(personWrapper.getNationality());
		personDao.save(person);
		return true;
	}
	
	public List<PersonWrapper> showPersons(){
		List<PersonWrapper> persons = new ArrayList<PersonWrapper>();
		for(Person person: personDao.findAll()){
			persons.add(new PersonWrapper(person));
		}
		return persons;
	}
	public boolean deletePerson(int personId){
		personDao.delete(personDao.findById(personId));
		return true;
	}
	public boolean updatePerson(int idPerson, PersonWrapper personWrapper){
		Person person = personDao.findById(idPerson);
		person.setBirthdate(personWrapper.getBirthdate());
		person.setName(personWrapper.getName());
		person.setNationality(personWrapper.getNationality());
		personDao.save(person);
		return true;
	}
	public PersonWrapper getPerson(int idPerson){
		return new PersonWrapper(personDao.findById(idPerson));
	}
}
