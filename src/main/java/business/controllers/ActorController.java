package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.ActorWrapper;
import data.daos.PersonDao;
import data.entities.Interpretation;
import data.entities.Person;

@Controller
public class ActorController {

	private PersonDao personDao;
	
	@Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
	
	public List<ActorWrapper> showActors() {
        List<ActorWrapper> actorsList = new ArrayList<>();
        for (Person person : personDao.findActors()) {
        	actorsList.add(new ActorWrapper(person));
        }
        return actorsList;
    }
	
	public boolean createActor(ActorWrapper actorWrapper) {
        Person person = new Person();
        Interpretation actor = new Interpretation();
        person.setName(actorWrapper.getName());
        person.setNationality(actorWrapper.getNationality());
        person.setBirthdate(actorWrapper.getBirthdate());
        person.setActor(actor);
        personDao.save(person);
        return true;
    }
	
}
