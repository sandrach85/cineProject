package data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private List<Person> directors;
        
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> actors;
    
    @Enumerated(EnumType.STRING)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Theme> theme;
        

	public Film() {
		
	}

	public Film(String title, String country, int year, String argument, List<Person> directors, List<Person> actors,
			List<Theme> theme) {
		super();
		this.title = title;
		this.country = country;
		this.year = year;
		this.argument = argument;
		this.directors = directors;
		this.actors = actors;
		this.theme = theme;
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

	public List<Person> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Person> directors) {
		this.directors = directors;
	}

	public List<Person> getActors() {
		return actors;
	}

	public void setActors(List<Person> actors) {
		this.actors = actors;
	}

	public List<Theme> getTheme() {
		return theme;
	}

	public void setTheme(List<Theme> theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", country=" + country + ", year=" + year + ", argument="
				+ argument + ", directors=" + directors + ", actors=" + actors + ", theme=" + theme + "]";
	}


    
    

}
