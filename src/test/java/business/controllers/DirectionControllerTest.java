package business.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.DirectionWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.daos.DirectionDao;
import data.daos.PersonDao;
import data.entities.Film;
import data.entities.Direction;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class DirectionControllerTest {
	@Autowired
	DirectionController directionController;
	
	@Autowired
	DirectionDao directionDao;
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	FilmDao filmDao;
	
	@Test
	public void getDirectionTest(){
		DirectionWrapper direcion = directionController.getDirection(1);
		assertEquals(directionDao.findById(1).getDirector(), direcion.getDirector());
		assertEquals(directionDao.findById(1).getFilm(), direcion.getFilm());
	}
	@Test
	public void createDirectionTest(){
		int numDirections = directionDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(2);
		directionController.createDirection(new DirectionWrapper(new Direction(person,film)));
		assertEquals(numDirections+1, directionDao.findAll().size());
	}
	
	@Test
	public void showDirectionsTest(){
		int numDirections = directionDao.findAll().size();
		assertEquals(numDirections, directionController.showDirections().size());
	}

	@Test
	public void deleteDirectionTest(){
		int aux = directionDao.findAll().size();
		directionController.deleteDirection(1);
		assertEquals(aux-1, directionDao.findAll().size());
	}
	
	@Test
	public void updateDirectionTest(){
		Direction direction = directionDao.findById(2);
		direction.setFilm(filmDao.findById(1));
		DirectionWrapper direcionWrapper = new DirectionWrapper(direction);
		directionController.updateDirection(2, direcionWrapper);
		assertTrue(directionDao.findById(2).getFilm().getId() == 1);
	}
}

