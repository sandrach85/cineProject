package business.wrapper;

import data.entities.Person;

public class ActorWrapper {
	
	private int idPerson;
	private String name;
	private String nationality;
	private String birthdate;
	private int idActor;
	
	
	public ActorWrapper() {
		
	}
	
	public ActorWrapper(String name, String nationality, String birthdate, int idActor) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
		this.idActor = idActor;
	}
	
	public ActorWrapper(Person person) {
		this.idPerson = person.getId();
		this.name = person.getName();
		this.nationality = person.getNationality();
		this.idActor = person.getActor().getId();
	}

	public int getId() {
		return idPerson;
	}

	public void setId(int id) {
		this.idPerson = id;
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

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	@Override
	public String toString() {
		return "ActorWrapper [name=" + name + ", nationality=" + nationality + ", birthdate=" + birthdate
				+ ", idActor=" + idActor + "]";
	}
		
}
