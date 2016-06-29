package business.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.FilmWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.entities.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class FilmControllerTest {
	@Autowired
	FilmController filmController;
	
	@Autowired
	FilmDao filmDao;
	@Test
	public void getFilmTest(){
		FilmWrapper film = filmController.getFilm(1);
		assertEquals(filmDao.findById(1).getTitle(), film.getTitle());
	}
	@Test
	public void createFilmTest(){
		int numFilms = filmDao.findAll().size();
		Film film = new Film("NTitle", "NCountry",12345, "NArgument");
		filmController.createFilm(new FilmWrapper(film));
		assertEquals(numFilms+1, filmDao.findAll().size());
	}
	
	@Test
	public void showFilmsTest(){
		int numFilms = filmDao.findAll().size();
		assertEquals(numFilms, filmController.showFilms().size());
	}

	@Test
	public void deleteFilmTest(){
		int aux = filmDao.findAll().size();
		filmController.deleteFilm(3);
		assertEquals(aux-1, filmDao.findAll().size());
	}
	
	@Test
	public void updateFilmTest(){
		Film film = filmDao.findById(2);
		film.setTitle("new name");
		FilmWrapper filmWrapper = new FilmWrapper(film);
		filmController.updateFilm(2, filmWrapper);
		assertTrue(filmDao.findById(2).getTitle().equals("new name"));
	}
}
