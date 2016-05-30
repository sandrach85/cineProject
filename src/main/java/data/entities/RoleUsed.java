package data.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class RoleUsed {

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn
    private Person person;
    
    @Enumerated(EnumType.STRING)
    private Role role;

	public RoleUsed(Person person, Role role) {
        assert person != null && role != null;
		this.person = person;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		RoleUsed other = (RoleUsed) obj;
		if (id != other.id)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rol usado [id=" + id + ", persona=" + person + ", rol=" + role + "]";
	}
    
    
}
