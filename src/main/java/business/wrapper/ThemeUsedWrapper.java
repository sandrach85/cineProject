package business.wrapper;

import data.entities.Film;
import data.entities.Theme;
import data.entities.ThemeUsed;

public class ThemeUsedWrapper {
	
	private int id;
	private Theme theme;
	private Film film;
	public ThemeUsedWrapper() {}
	public ThemeUsedWrapper(ThemeUsed themeUsed) {
		this.theme = themeUsed.getTheme();
		this.film = themeUsed.getFilm();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	@Override
	public String toString() {
		return "ThemeUsedWrapper [id=" + id + ", theme=" + theme + ", film=" + film + "]";
	}
	
}
