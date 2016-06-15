package business.wrapper;

import data.entities.Person;

public class DirectorWrapper {

	private int idPerson;
	private String name;
	private String nationality;
	private String birthdate;
	private int idDirector;
	
	
	public DirectorWrapper() {
		super();
	}
	
	public DirectorWrapper(String name, String nationality, String birthdate, int idDirector) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.idDirector = idDirector;
	}
	
	public DirectorWrapper(Person person) {
		this.idPerson = person.getId();
		this.name = person.getName();
		this.nationality = person.getNationality();
		this.idDirector = person.getDirector().getId();
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}

	@Override
	public String toString() {
		return "DirectorWrapper [name=" + name + ", nationality=" + nationality + ", birthdate=" + birthdate
				+ ", idDirector=" + idDirector + "]";
	}
		
}
