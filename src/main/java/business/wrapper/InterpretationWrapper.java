package business.wrapper;

import data.entities.Film;
import data.entities.Interpretation;
import data.entities.Person;

public class InterpretationWrapper {
	
	private int id;
	
	private Person actor;
	private Film film;
	
	public InterpretationWrapper(){}
	
	public InterpretationWrapper(Interpretation interpretation) {
		this.actor = interpretation.getActor();
		this.film = interpretation.getFilm();
	}

	public Person getActor() {
		return this.actor;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setActor(Person actor) {
		this.actor = actor;
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
		return "InterpretationWrapper [actor=" + actor + ", film=" + film + "]";
	}
	
	
}
