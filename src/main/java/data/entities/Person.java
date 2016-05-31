package data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	
    @Id
    @GeneratedValue
    private int id;

	private String name;
	private String nationality;
	private String birthdate;
	
	private final int MAX_ROLES = 2;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	public Person() {
	}

	public Person(String name, String nationality, String birthdate, List<Role> rolesList) {
		assert name != null && nationality != null && birthdate != null;
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
		for(int i=0; i<roles.size();i++){
			this.roles.add(rolesList.get(i).roleName());
		}
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

	public List<String> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Person other = (Person) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (id != other.id)
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
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", nationality=" + nationality + ", birthdate=" + birthdate
				+ ", roles=" + roles +  "]";
	}
	
	public boolean addRole(Role role){
		boolean result = false;
		if(roles.size()<MAX_ROLES && !hasRole(role)){
			roles.add(role.roleName());
		}
		return result;
	}

	public boolean hasRole(Role role) {
		for(int i = 0; i< roles.size(); i++){
			if(roles.get(i).equals(role.roleName())){
				return true;
			}
		}
		return false;
	}
	
}
