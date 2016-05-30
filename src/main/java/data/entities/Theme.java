package data.entities;

public enum Theme {
	TERROR, LOVE, ACTION, ADVENTURE, HUMOR;	
	
	public String themeName() {
        return "THEME_" + this.toString();
    }

}
