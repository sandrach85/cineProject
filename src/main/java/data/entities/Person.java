package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	
    @Id
    @GeneratedValue
    private int id;

	private String name;
	private String nationality;
	private String birthdate;
	
	
	public Person() {
	}

	public Person(String name, String nationality, String birthdate) {
		assert name != null && nationality != null && birthdate != null;
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
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
		return "Persona [id=" + id + ", nombre=" + name + ", nacionalidad=" + nationality + ", fecha de nacimiento=" + birthdate
				+ "]";
	}
	
	
}
