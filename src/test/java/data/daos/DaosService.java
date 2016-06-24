package data.daos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Person;
import data.services.DataService;

@Service
public class DaosService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private DataService genericService;

	@PostConstruct
	public void populate() {
		this.createPersons();
	}

	public void createPersons() {
		Person p1 = new Person("Ben Affleck", "EEUU", "15-08-1972");
		Person p2 = new Person("Sasha Grey", "EEUU", "14-03-1988");
		personDao.save(p1);
		personDao.save(p2);
	}
	
	public void deleteAll() {
		genericService.deleteAll();
	}
}
