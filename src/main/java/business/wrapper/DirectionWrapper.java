package business.wrapper;

import data.entities.Direction;
import data.entities.Film;
import data.entities.Person;

public class DirectionWrapper {
	
	private int id;
	
	private Person director;
	private Film film;
	
	public DirectionWrapper(){}

	public DirectionWrapper(Direction direction) {
		this.director = direction.getDirector();
		this.film = direction.getFilm();
	}

	public Person getDirector() {
		return director;
	}

	public Film getFilm() {
		return film;
	}
	
	public void setDirector(Person director) {
		this.director = director;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	@Override
	public String toString() {
		return "DirectionWrapper [id=" + id + ", director=" + director + ", film=" + film + "]";
	}
	
}
