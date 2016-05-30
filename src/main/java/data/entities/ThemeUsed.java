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
    private Film film;
    
    @Enumerated(EnumType.STRING)
    private Theme theme;

	public ThemeUsed(Film film, Theme theme) {
		assert film != null && theme != null;
		this.film = film;
		this.theme = theme;
	}
	
	public int getId() {
		return id;
	}
    
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (theme != other.theme)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThemeUsed [id=" + id + ", film=" + film + ", theme=" + theme + "]";
	}
  
}
