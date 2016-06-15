package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Direction() {
		
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Direction [id=" + id + "]";
	}
	
	

}
