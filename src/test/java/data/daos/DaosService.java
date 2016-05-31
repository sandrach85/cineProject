package data.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Person;
import data.entities.Role;
import data.services.DataService;


@Service
public class DaosService {
	
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired
    private DataService genericService;
            
    @PostConstruct
    public void populate(){
    	this.createPersons();
    	//this.createFilms();
    }
    
    public Person[] createPersons(){
    	Person[] persons = new Person[11];
    	ArrayList<Role> roles = new ArrayList<Role>();
    	roles.add(Role.DIRECTOR);
    	roles.add(Role.ACTOR);
    	persons[0] = new Person("Ben Affleck","EEUU","15-08-1972", roles);
    	personDao.save(persons[0]);
    	roles.clear();
    	roles.add(Role.ACTOR);
        persons[1] = new Person("Sasha Grey","EEUU","14-03-1988", roles);
    	personDao.save(persons[1]);
    	roles.clear();
    	roles.add(Role.ACTOR);
        persons[2] = new Person("Chloë Grace Moretz","EEUU","10-02-1997", roles);
    	personDao.save(persons[2]);
    	roles.clear();
    	roles.add(Role.ACTOR);
        persons[3] = new Person("Mario Casas","España","12-06-1986", roles);
    	personDao.save(persons[3]);
    	roles.clear();
    	roles.add(Role.ACTOR);
        persons[4] = new Person("Chris Evans","EEUU","13-06-1981", roles);
    	personDao.save(persons[4]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
    	roles.add(Role.ACTOR);
        persons[5] = new Person("Antonio Banderas","España","10-08-1960", roles);
    	personDao.save(persons[5]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
    	roles.add(Role.ACTOR);
        persons[6] = new Person("Quentin Tarantino","EEUU","27-03-1963", roles);
    	personDao.save(persons[6]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
    	roles.add(Role.ACTOR);
        persons[7] = new Person("Martin Scorsese","EEUU","17-11-1942", roles);
    	personDao.save(persons[7]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
        persons[8] = new Person("Steven Spielberg","EEUU","18-12-1946", roles);
    	personDao.save(persons[8]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
        persons[9] = new Person("Tim Burton","EEUU","25-08-1958", roles);
    	personDao.save(persons[9]);
    	roles.clear();
    	roles.add(Role.DIRECTOR);
        persons[10] = new Person("Alfred Hitchcock","Reino Unido","13-08-1899", roles);
    	personDao.save(persons[10]);
    	return persons;
    }
    
    private List<Person> addActors(int id1, int id2, int id3){
    	List<Person> listActors = new ArrayList<Person>();
    	listActors.add(personDao.findById(id1));
    	listActors.add(personDao.findById(id2));
    	listActors.add(personDao.findById(id3));    	
    	return listActors;
    }
    
    private List<Person> addDirectors(int id1, int id2){
    	List<Person> listDirectors = new ArrayList<Person>();
    	listDirectors.add(personDao.findById(id1));
    	listDirectors.add(personDao.findById(id2));   	
    	return listDirectors;
    }
    
    private List<Person> addDirector(int id){
    	List<Person> listDirector = new ArrayList<Person>();
    	listDirector.add(personDao.findById(id)); 	
    	return listDirector;
    }
    
   // public Film[] createFilms(){
    	//Film m = new Film ("Pearl Harbour","EEUU",2001,"argumento de la pelicula");
    //}
    
    public void deleteAll() {
        genericService.deleteAll();
    }
}
