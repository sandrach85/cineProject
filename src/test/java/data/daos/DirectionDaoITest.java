package data.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Direction;
import data.entities.Film;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })

public class DirectionDaoITest {
	@Autowired
	private DirectionDao directionDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Test
	public void testAddInterpretation(){
		int aux = directionDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(2);
		directionDao.addDirection(new Direction(person, film));
		assertEquals(aux+1, directionDao.findAll().size());
	}
	
	@Test
	public void testRemoveInterpretation(){
		int aux = directionDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(1);
		directionDao.removeDirection(new Direction(person, film));
		assertEquals(aux-1, directionDao.findAll().size());
	}
	
	@Test
	public void testFindById() {
		Direction direction = directionDao.findById(2);
		assertEquals(1, direction.getDirector().getId());
	}
}
