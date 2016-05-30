package data.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class RoleUsed {

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER)
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
	public String toString() {
		return "Rol usado [id=" + id + ", persona=" + person + ", rol=" + role + "]";
	}
    
    
}
