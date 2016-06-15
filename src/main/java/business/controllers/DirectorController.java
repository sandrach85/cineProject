package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.DirectorWrapper;
import data.daos.PersonDao;
import data.entities.Person;

@Controller
public class DirectorController {

	private PersonDao personDao;
	
	@Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
	
	public List<DirectorWrapper> showDirector() {
        List<DirectorWrapper> directorList = new ArrayList<>();
        for (Person person : personDao.findDirectors()) {
        	directorList.add(new DirectorWrapper(person));
        }
        return directorList;
    }
	
}
