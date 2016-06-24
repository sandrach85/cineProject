package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn
	private Person director;
	
	@ManyToOne
	@JoinColumn
	private Film film;

	public Direction() {}
	
	public Direction(Person director, Film film){
		this.director = director;
		this.film = film;
	}

	public int getId() {
		return id;
	}

	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "Direction [id=" + id + ", director=" + director + ", film=" + film + "]";
	}
}
