package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interpretation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Interpretation() {
		
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Interpretation [id=" + id + "]";
	}

}
