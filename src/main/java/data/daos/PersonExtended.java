package data.daos;

import java.util.List;

import data.entities.Person;

public interface PersonExtended {
	
	public List<Person> findActors();
	
	public List<Person> findDirectors();

}
