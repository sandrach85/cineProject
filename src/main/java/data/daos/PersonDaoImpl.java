package data.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.entities.Person;

public class PersonDaoImpl implements PersonExtended{

	@Autowired
    private PersonDao personDao;
	
	@Override
	public List<Person> findActors() {
		List<Person> persons = personDao.findAll();
		List<Person> actors = new ArrayList<>();
		for (int i =0; i<persons.size(); i++){
			if (persons.get(i).getActor()!=null){
				actors.add(persons.get(i));
			}
		}
		return actors;
	}

	@Override
	public List<Person> findDirectors() {
		List<Person> persons = personDao.findAll();
		List<Person> directors = new ArrayList<>();
		for (int i =0; i<persons.size(); i++){
			if (persons.get(i).getDirector()!=null){
				directors.add(persons.get(i));
			}
		}
		return directors;
	}

}
