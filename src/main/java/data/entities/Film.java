package data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


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
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<Theme> themes;

	public Film(int id, String title, String country, int year, String argument) {
		super();
		this.id = id;
		this.title = title;
		this.country = country;
		this.year = year;
		this.argument = argument;
		this.actors = new ArrayList<Person>();
		this.directors = new ArrayList<Person>();
		this.themes = new ArrayList<Theme>();
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

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((argument == null) ? 0 : argument.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + id;
		result = prime * result + ((themes == null) ? 0 : themes.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
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
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
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

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", country=" + country + ", year=" + year + ", argument="
				+ argument + ", directors=" + directors + ", actors=" + actors + ", themes=" + themes + "]";
	}
	
	public boolean addTheme(Theme theme){
		boolean result = false;
		if(!hasTheme(theme)){
			result = themes.add(theme);
		}
		return result;
	}
	public boolean hasTheme(Theme theme){
		for(int i=0; i<themes.size(); i++){
			if(theme.equals(theme)){
				return true;
			}
		}
		return false;
	}
	
    public boolean addActor(Person actor){
    	boolean result = false;
    	if(!isActor(actor) && actor.hasRole(Role.ACTOR)){
    		result = actors.add(actor);
    	}
    	return result;
    }
    
    public boolean isActor(Person actor){
    	for(int i=0; i<actors.size(); i++){
    		if(actors.get(i).equals(actor)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean addDirector(Person director){
    	boolean result = false;
    	if(!isDirector(director) && director.hasRole(Role.DIRECTOR)){
    		result = directors.add(director);
    	}
    	return result;
    }
    
    public boolean isDirector(Person director){
    	for(int i=0; i<directors.size(); i++){
    		if(directors.get(i).equals(director)){
    			return true;
    		}
    	}
    	return false;
    }
	
}
