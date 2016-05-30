package data.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	private Calendar birthdate;
	
	
	public Person() {
	}

	public Person(String name, String nationality, Calendar birthdate) {
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

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		String date = new SimpleDateFormat("HH:00 dd-MM-yyyy ").format(birthdate.getTime());
		return "Persona [id=" + id + ", nombre=" + name + ", nacionalidad=" + nationality + ", fecha de nacimiento=" + date
				+ "]";
	}
	
	
}
