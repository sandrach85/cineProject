package data.daos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Direction;
import data.entities.Film;
import data.entities.Interpretation;
import data.entities.Person;
import data.entities.Theme;
import data.entities.ThemeUsed;
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
	private InterpretationDao interpretationDao;
	
	@Autowired
	private DirectionDao directionDao;
	
	@Autowired
	private ThemeUsedDao themeUsedDao;

	@Autowired
	private DataService genericService;

	@PostConstruct
	public void populate() {
		this.createPersons();
		this.createFilms();
		this.createThemes();
		this.createInterpretations();
		this.createDirections();
		this.createThemeUsedDao();
	}

	public void createPersons() {
		Person p1 = new Person("Ben Affleck", "EEUU", "15-08-1972");
		Person p2 = new Person("Angelina Jolie", "EEUU", "04-06-1975");
		Person p3 = new Person("Brad Pitt", "EEUU", "18-06-1963");
		Person p4 = new Person("NName", "NCountry", "NDate");
		personDao.save(p1);
		personDao.save(p2);
		personDao.save(p3);
		personDao.save(p4);
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
		Theme t3 = new Theme("COMEDY");
		themeDao.save(t1);
		themeDao.save(t2);
		themeDao.save(t3);
	}
	
	public void createInterpretations(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(1);
		Interpretation t1 = new Interpretation(p1,f1);
		interpretationDao.save(t1);
		Person p2 = personDao.findById(2);
		Interpretation t2 = new Interpretation(p2, f1);
		interpretationDao.save(t2);
	}
	
	public void createDirections(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(1);
		Direction t1 = new Direction(p1,f1);
		directionDao.save(t1);
		Person p2 = personDao.findById(3);
		Film f2 = filmDao.findById(2);
		Direction t2 = new Direction(p2, f2);
		directionDao.save(t2);
	}
	
	public void createThemeUsedDao(){
		Film f1 = filmDao.findById(1);
		Theme t1 = themeDao.findById(1);
		ThemeUsed tu1 = new ThemeUsed(f1, t1);
		themeUsedDao.save(tu1);
		Film f2 = filmDao.findById(2);
		Theme t2 = themeDao.findById(2);
		ThemeUsed tu2 = new ThemeUsed(f2, t2);
		themeUsedDao.save(tu2);
	}
	
	public void deleteAll() {
		genericService.deleteAll();
	}
}
