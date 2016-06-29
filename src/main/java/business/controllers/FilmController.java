package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.FilmWrapper;
import data.daos.FilmDao;
import data.entities.Film;

@Controller
public class FilmController {
	private FilmDao filmDao;
	@Autowired
	public void setFilmDao(FilmDao filmDao){
		this.filmDao = filmDao;
	}
	public boolean createFilm(FilmWrapper filmWrapper){
		Film film = new Film();
		film.setArgument(filmWrapper.getArgument());
		film.setCountry(filmWrapper.getCountry());
		film.setTitle(filmWrapper.getTitle());
		film.setYear(filmWrapper.getYear());
		filmDao.save(film);
		return true;
	}
	
	public List<FilmWrapper> showFilms(){
		List<FilmWrapper> films = new ArrayList<FilmWrapper>();
		for(Film film: filmDao.findAll()){
			films.add(new FilmWrapper(film));
		}
		return films;
	}
	public boolean deleteFilm(int filmId){
		if(filmDao.findById(filmId)==null){
			return false;
		}
		filmDao.delete(filmDao.findById(filmId));
		return true;
	}
	public boolean updateFilm(int idfilm, FilmWrapper filmWrapper){
		Film film = filmDao.findById(idfilm);
		if(film == null){
			return false;
		}
		film.setArgument(filmWrapper.getArgument());
		film.setCountry(filmWrapper.getCountry());
		film.setTitle(filmWrapper.getTitle());
		film.setYear(filmWrapper.getYear());
		filmDao.save(film);
		return true;
	}
	public FilmWrapper getFilm(int idfilm){
		return new FilmWrapper(filmDao.findById(idfilm));
	}
}
