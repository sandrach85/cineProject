package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Person;

public interface PersonDao  extends JpaRepository<Person, Integer>, PersonExtended{
	
	Person findById(int id);

}
