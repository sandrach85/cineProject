package data.daos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Film;
import data.entities.Person;
import data.entities.Theme;
import data.services.DataService;

@Service
public class DaosService {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private ThemeDao themeDao;

	@Autowired
	private DataService genericService;

	@PostConstruct
	public void populate() {
		this.createPersons();
		this.createFilms();
		this.createThemes();
	}

	public void createPersons() {
		Person p1 = new Person("Ben Affleck", "EEUU", "15-08-1972");
		Person p2 = new Person("Angelina Jolie", "EEUU", "14-03-1988");
		personDao.save(p1);
		personDao.save(p2);
	}
	
	public void createFilms(){
		Film f1 = new Film("Title", "Country",1234, "Argument");
		Film f2 = new Film("Title", "Country",1234, "Argument");
		filmDao.save(f1);
		filmDao.save(f2);
		
	}
	
	public void createThemes(){
		Theme t1 = new Theme("ACTION");
		Theme t2 = new Theme("LOVE");
		themeDao.save(t1);
		themeDao.save(t2);
	}
	
	public void deleteAll() {
		genericService.deleteAll();
	}
}
