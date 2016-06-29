package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	public Theme(){}
	
	public Theme(String name){
		this.setName(name);
	}
	public String themeName() {
        return "THEME_" + this.toString();
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + "]";
	}
	
}
