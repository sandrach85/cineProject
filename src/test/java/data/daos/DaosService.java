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
	private FilmDao filmDao;

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private DirectionDao directorDao;
	
	@Autowired
	private InterpretationDao actorDao;

	@Autowired
	private ThemeUsedDao themeUsedDao;

	@Autowired
	private DataService genericService;

	@PostConstruct
	public void populate() {
		this.createPersons();
		this.createFilms();
		this.addDirectors();
		this.addActors();
		this.addDirectorInFilm();
		this.addActorsInFilm();
	}

	public Person[] createPersons() {
		Person[] persons = new Person[11];
		createDirectors();
		createActors();
		persons[0] = new Person("Ben Affleck", "EEUU", "15-08-1972");
		personDao.save(persons[0]);
		persons[1] = new Person("Sasha Grey", "EEUU", "14-03-1988");
		personDao.save(persons[1]);
		persons[2] = new Person("Chloë Grace Moretz", "EEUU", "10-02-1997");
		personDao.save(persons[2]);
		persons[3] = new Person("Mario Casas", "España", "12-06-1986");
		personDao.save(persons[3]);
		persons[4] = new Person("Chris Evans", "EEUU", "13-06-1981");
		personDao.save(persons[4]);
		persons[5] = new Person("Antonio Banderas", "España", "10-08-1960");
		personDao.save(persons[5]);
		persons[6] = new Person("Quentin Tarantino", "EEUU", "27-03-1963");
		personDao.save(persons[6]);
		persons[7] = new Person("Martin Scorsese", "EEUU", "17-11-1942");
		personDao.save(persons[7]);
		persons[8] = new Person("Steven Spielberg", "EEUU", "18-12-1946");
		personDao.save(persons[8]);
		persons[9] = new Person("Tim Burton", "EEUU", "25-08-1958");
		personDao.save(persons[9]);
		persons[10] = new Person("Alfred Hitchcock", "Reino Unido", "13-08-1899");
		personDao.save(persons[10]);
		return persons;
	}
	
	private void createDirectors(){
		for(int i =0; i<11; i++){
			Direction director = new Direction();
			directorDao.save(director);
		}
	}
	
	private void createActors(){
		for(int i =0; i<11; i++){
			Interpretation actor = new Interpretation();
			actorDao.save(actor);
		}
	}
	
	private void asignDirectors(int idP, int idD){
		Person person = personDao.findById(idP);
		person.setDirector(directorDao.findById(idD));
		personDao.save(person);
	}
	
	private void asignActors(int idP, int idA){
		Person person = personDao.findById(idP);
		person.setActor(actorDao.findById(idA));
		personDao.save(person);
	}
	
	private void asignDirectorInFilm(int idP, int id){
		Film film = filmDao.findById(idP);
		film.addDirectorInFilm((directorDao.findById(id)));
		filmDao.save(film);
	}
	
	private void asignActorsInFilm(int idP, int id1, int id2, int id3){
		Film film = filmDao.findById(idP);
		film.addActorInFilm((actorDao.findById(id1)));
		film.addActorInFilm((actorDao.findById(id2)));
		film.addActorInFilm((actorDao.findById(id3)));
		filmDao.save(film);
	}
	
	public void addDirectors(){
		asignDirectors(1, 1);
		asignDirectors(5, 2);
		asignDirectors(7, 3);
		asignDirectors(8, 4);
		asignDirectors(9, 5);
		asignDirectors(10, 6);
		asignDirectors(11, 7);
	}
	
	public void addActors(){
		asignActors(1, 1);
		asignActors(2, 2);
		asignActors(3, 3);
		asignActors(4, 4);
		asignActors(5, 5);
		asignActors(6, 6);
		asignActors(7, 7);
		asignActors(8, 8);
	}
	
	public void addDirectorInFilm(){
		asignDirectorInFilm(1, 1);
		asignDirectorInFilm(1, 5);
		asignDirectorInFilm(2, 7);
		asignDirectorInFilm(3, 8);
		asignDirectorInFilm(4, 9);
		asignDirectorInFilm(4, 10);
		asignDirectorInFilm(5, 11);
		asignDirectorInFilm(6, 1);
		asignDirectorInFilm(7, 5);
		asignDirectorInFilm(8, 7);
		asignDirectorInFilm(8, 8);
		asignDirectorInFilm(9, 11);
	}
	
	
	public void addActorsInFilm(){
		asignActorsInFilm(1, 1, 2, 3);
		asignActorsInFilm(2, 2, 3, 4);
		asignActorsInFilm(3, 3, 4, 5);
		asignActorsInFilm(4, 5, 6, 7);
		asignActorsInFilm(5, 6, 7, 8);
		asignActorsInFilm(6, 7, 8, 1);
		asignActorsInFilm(7, 8, 1, 2);
		asignActorsInFilm(8, 2, 4, 6);
		asignActorsInFilm(9, 1, 3, 5);
	}

	
	public Film[] createFilms() {
		Film[] films = new Film[9];
		films[0] = new Film("Pearl Harbour", "EEUU", 2001, "argumento de la pelicula");
		filmDao.save(films[0]);
		System.out.println(films[0]);
		themeUsedDao.save(new ThemeUsed(films[0], Theme.ACTION));
		themeUsedDao.save(new ThemeUsed(films[0], Theme.ADVENTURE));
		films[1] = new Film("Argo", "EEUU", 2012, "argumento de la pelicula");
		filmDao.save(films[1]);
		System.out.println(films[1]);
		themeUsedDao.save(new ThemeUsed(films[1], Theme.ACTION));
		themeUsedDao.save(new ThemeUsed(films[1], Theme.ADVENTURE));
		films[2] = new Film("Altamira", "España", 2016, "argumento de la pelicula");
		filmDao.save(films[2]);
		System.out.println(films[2]);
		themeUsedDao.save(new ThemeUsed(films[2], Theme.ADVENTURE));
		films[3] = new Film("El camino de los ingleses", "EEUU", 2006, "argumento de la pelicula");
		filmDao.save(films[3]);
		System.out.println(films[3]);
		themeUsedDao.save(new ThemeUsed(films[3], Theme.LOVE));
		themeUsedDao.save(new ThemeUsed(films[3], Theme.ADVENTURE));
		films[4] = new Film("A todo gas", "EEUU", 2001, "argumento de la pelicula");
		filmDao.save(films[4]);
		System.out.println(films[4]);
		themeUsedDao.save(new ThemeUsed(films[4], Theme.ACTION));
		films[5] = new Film("Alvin y las Ardillas", "EEUU", 2007, "argumento de la pelicula");
		filmDao.save(films[5]);
		System.out.println(films[5]);
		themeUsedDao.save(new ThemeUsed(films[5], Theme.HUMOR));
		films[6] = new Film("American Pie", "EEUU", 1999, "argumento de la pelicula");
		filmDao.save(films[6]);
		System.out.println(films[6]);
		themeUsedDao.save(new ThemeUsed(films[6], Theme.HUMOR));
		films[7] = new Film("Anastasia", "EEUU", 1997, "argumento de la pelicula");
		filmDao.save(films[7]);
		System.out.println(films[7]);
		themeUsedDao.save(new ThemeUsed(films[7], Theme.HUMOR));
		films[8] = new Film("Ahora me ves", "EEUU", 1997, "argumento de la pelicula");
		filmDao.save(films[8]);
		System.out.println(films[8]);
		themeUsedDao.save(new ThemeUsed(films[8], Theme.TERROR));
		themeUsedDao.save(new ThemeUsed(films[8], Theme.ACTION));
		return films;
	}

	

	public void deleteAll() {
		genericService.deleteAll();
	}
}
