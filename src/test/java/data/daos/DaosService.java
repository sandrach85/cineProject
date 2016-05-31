package data.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Film;
import data.entities.Person;
import data.entities.Role;
import data.entities.RoleUsed;
import data.entities.Theme;
import data.entities.ThemeUsed;
import data.services.DataService;


@Service
public class DaosService {
	
    @Autowired
    private FilmDao filmDao;
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired
    private RoleUsedDao roleUsedDao;
    
    @Autowired
    private ThemeUsedDao themeUsedDao;
    
    @Autowired
    private DataService genericService;
            
    @PostConstruct
    public void populate(){
    	this.createPersons();
    	this.createFilms();
    }
    
    public Person[] createPersons(){
    	Person[] persons = new Person[11];
    	persons[0] = new Person("Ben Affleck","EEUU","15-08-1972");
    	personDao.save(persons[0]);
        roleUsedDao.save(new RoleUsed(persons[0], Role.DIRECTOR));
        roleUsedDao.save(new RoleUsed(persons[0], Role.ACTOR));
        persons[1] = new Person("Sasha Grey","EEUU","14-03-1988");
    	personDao.save(persons[1]);
        roleUsedDao.save(new RoleUsed(persons[1], Role.ACTOR));
        persons[2] = new Person("Chloë Grace Moretz","EEUU","10-02-1997");
    	personDao.save(persons[2]);
        roleUsedDao.save(new RoleUsed(persons[2], Role.ACTOR));
        persons[3] = new Person("Mario Casas","España","12-06-1986");
    	personDao.save(persons[3]);
        roleUsedDao.save(new RoleUsed(persons[3], Role.ACTOR));
        persons[4] = new Person("Chris Evans","EEUU","13-06-1981");
    	personDao.save(persons[4]);
        roleUsedDao.save(new RoleUsed(persons[4], Role.ACTOR));
        persons[5] = new Person("Antonio Banderas","España","10-08-1960");
    	personDao.save(persons[5]);
        roleUsedDao.save(new RoleUsed(persons[5], Role.DIRECTOR));
        roleUsedDao.save(new RoleUsed(persons[5], Role.ACTOR));
        persons[6] = new Person("Quentin Tarantino","EEUU","27-03-1963");
    	personDao.save(persons[6]);
        roleUsedDao.save(new RoleUsed(persons[6], Role.DIRECTOR));
        roleUsedDao.save(new RoleUsed(persons[6], Role.ACTOR));
        persons[7] = new Person("Martin Scorsese","EEUU","17-11-1942");
    	personDao.save(persons[7]);
        roleUsedDao.save(new RoleUsed(persons[7], Role.DIRECTOR));
        roleUsedDao.save(new RoleUsed(persons[7], Role.ACTOR));
        persons[8] = new Person("Steven Spielberg","EEUU","18-12-1946");
    	personDao.save(persons[8]);
        roleUsedDao.save(new RoleUsed(persons[8], Role.DIRECTOR));
        persons[9] = new Person("Tim Burton","EEUU","25-08-1958");
    	personDao.save(persons[9]);
        roleUsedDao.save(new RoleUsed(persons[9], Role.DIRECTOR));
        persons[10] = new Person("Alfred Hitchcock","Reino Unido","13-08-1899");
    	personDao.save(persons[10]);
        roleUsedDao.save(new RoleUsed(persons[10], Role.DIRECTOR));
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
    
    public Film[] createFilms(){
    	Film[] films = new Film[9];
    	films[0] = new Film("Pearl Harbour","EEUU",2001,"argumento de la pelicula");
    	filmDao.save(films[0]);
    	themeUsedDao.save(new ThemeUsed(films[0],Theme.ACTION));
    	themeUsedDao.save(new ThemeUsed(films[0],Theme.ADVENTURE));
    	films[1] = new Film("Argo","EEUU",2012,"argumento de la pelicula");
    	filmDao.save(films[1]);
    	themeUsedDao.save(new ThemeUsed(films[1],Theme.ACTION));
    	themeUsedDao.save(new ThemeUsed(films[1],Theme.ADVENTURE));
    	films[2] = new Film("Altamira","España",2016,"argumento de la pelicula");
    	filmDao.save(films[2]);
    	themeUsedDao.save(new ThemeUsed(films[2],Theme.ADVENTURE));
    	films[3] = new Film("El camino de los ingleses","EEUU",2006,"argumento de la pelicula");
    	filmDao.save(films[3]);
    	themeUsedDao.save(new ThemeUsed(films[3],Theme.LOVE));
    	themeUsedDao.save(new ThemeUsed(films[3],Theme.ADVENTURE));
    	films[4] = new Film("A todo gas","EEUU",2001,"argumento de la pelicula");
    	filmDao.save(films[4]);
    	themeUsedDao.save(new ThemeUsed(films[4],Theme.ACTION));
    	films[5] = new Film("Alvin y las Ardillas","EEUU",2007,"argumento de la pelicula");
    	filmDao.save(films[5]);
    	themeUsedDao.save(new ThemeUsed(films[5],Theme.HUMOR));
    	films[6] = new Film("American Pie","EEUU",1999,"argumento de la pelicula");
    	filmDao.save(films[6]);
    	themeUsedDao.save(new ThemeUsed(films[6],Theme.HUMOR));
    	films[7] = new Film("Anastasia","EEUU",1997,"argumento de la pelicula");
    	filmDao.save(films[7]);
    	themeUsedDao.save(new ThemeUsed(films[7],Theme.HUMOR));
    	films[8] = new Film("Ahora me ves","EEUU",1997,"argumento de la pelicula");
    	filmDao.save(films[8]);
    	themeUsedDao.save(new ThemeUsed(films[8],Theme.TERROR));
    	themeUsedDao.save(new ThemeUsed(films[8],Theme.ACTION));
    	return films;
    }
    
    public void deleteAll() {
        genericService.deleteAll();
    }
}
