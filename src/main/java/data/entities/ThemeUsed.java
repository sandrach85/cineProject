package data.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ThemeUsed {

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Person person;
    
    @Enumerated(EnumType.STRING)
    private Theme theme;

	public ThemeUsed(Person person, Theme theme) {
		assert person != null && theme != null;
		this.person = person;
		this.theme = theme;
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
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
		ThemeUsed other = (ThemeUsed) obj;
		if (id != other.id)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThemeUsed [id=" + id + ", person=" + person + ", theme=" + theme + "]";
	}
  
}
