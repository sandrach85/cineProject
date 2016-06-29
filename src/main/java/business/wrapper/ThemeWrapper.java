package business.wrapper;

import data.entities.Theme;

public class ThemeWrapper {
	private int id;
	private String name;
	
	public ThemeWrapper(){}
	
	public ThemeWrapper(Theme theme){
		this.name=theme.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ThemeWrapper [id=" + id + ", name=" + name + "]";
	}
	
	
}
