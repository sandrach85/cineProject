package business.wrapper;

import data.entities.Film;

public class FilmWrapper {
	private int id;

	private String title;
	private String country;
	private int year;
	private String argument;

	public FilmWrapper() {}

	public FilmWrapper(Film film) {
		this.title = film.getTitle();
		this.country = film.getCountry();
		this.year = film.getYear();
		this.argument = film.getArgument();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "FilmWrapper [id=" + id + ", title=" + title + ", country=" + country + ", year=" + year + ", argument="
				+ argument + "]";
	}
	
	
}
