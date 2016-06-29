package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.NotFoundFilmIdException;
import business.controllers.FilmController;
import business.wrapper.FilmWrapper;

@RestController
@RequestMapping(Uris.FILMS)
public class FilmResource {
private FilmController filmController;
	
	@Autowired
	public void setFilmController(FilmController filmController){
		this.filmController = filmController;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FilmWrapper> showFilms(){
		return filmController.showFilms();
	}
	
	@RequestMapping(value = Uris.ID,method = RequestMethod.GET)
	public FilmWrapper showFilm(@PathVariable int id)throws NotFoundFilmIdException{
		FilmWrapper film = filmController.getFilm(id);
		if(film == null){
			throw new NotFoundFilmIdException("id: "+id);
		}
		return film;
	}
	
	@RequestMapping(value = Uris.ID ,method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable int id)throws NotFoundFilmIdException{
		if(!filmController.deleteFilm(id)){
			throw new NotFoundFilmIdException("id:" + id);
		}
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void createFilm(@RequestBody FilmWrapper film){
		filmController.createFilm(film);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateInterpretation(@RequestBody FilmWrapper film)throws NotFoundFilmIdException{
		if(!filmController.updateFilm(film.getId(), film)){
			throw new NotFoundFilmIdException("id: "+film.getId());
		}
	}
}
