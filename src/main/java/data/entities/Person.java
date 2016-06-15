package data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String nationality;
	private String birthdate;
	
	@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn
    private Direction director;
	
	@OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn
	private Interpretation actor;
	

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
	
	public Direction getDirector() {
		return director;
	}

	public void setDirector(Direction director) {
		this.director = director;
	}

	public Interpretation getActor() {
		return actor;
	}

	public void setActor(Interpretation actor) {
		this.actor = actor;
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
		Person other = (Person) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (id != other.id)
			return false;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", nationality=" + nationality + ", birthdate=" + birthdate
				+ ", idDirector=" + director + ", idActor=" + actor + "]";
	}

}
