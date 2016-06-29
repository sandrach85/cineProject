package business.wrapper;

import data.entities.Person;

public class PersonWrapper {
	private int id;
	private String name;
	private String nationality;
	private String birthdate;
	
	public PersonWrapper() {
	}

	public PersonWrapper(Person person) {
		assert name != null && nationality != null && birthdate != null;
		this.name = person.getName();
		this.nationality = person.getNationality();
		this.birthdate = person.getBirthdate();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PersonWrapper [id=" + id + ", name=" + name + ", nationality=" + nationality + ", birthdate="
				+ birthdate + "]";
	}
	
}
