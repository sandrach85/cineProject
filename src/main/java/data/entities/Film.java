package data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Film {

	@Id
	@GeneratedValue
	private int id;

	private String title;
	private String country;
	private int year;
	private String argument;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Direction> directors;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Interpretation> actors;

	public Film() {
		this.directors = new ArrayList<Direction>();
		this.actors = new ArrayList<Interpretation>();
	}

	public Film(String title, String country, int year, String argument) {
		this.title = title;
		this.country = country;
		this.year = year;
		this.argument = argument;
		this.directors = new ArrayList<Direction>();
		this.actors = new ArrayList<Interpretation>();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public List<Direction> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Direction> directors) {
		this.directors = directors;
	}

	public List<Interpretation> getActors() {
		return actors;
	}

	public void setActors(List<Interpretation> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (argument == null) {
			if (other.argument != null)
				return false;
		} else if (!argument.equals(other.argument))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public void addDirectorInFilm(Direction direc) {
		this.directors.add(direc);
	}

	public void addActorInFilm(Interpretation actor) {
		this.actors.add(actor);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", country=" + country + ", year=" + year + ", argument="
				+ argument + ", directors=" + directors + ", actors=" + actors + "]";
	}

}
