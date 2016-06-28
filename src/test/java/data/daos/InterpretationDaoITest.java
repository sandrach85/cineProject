package data.daos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.Film;
import data.entities.Interpretation;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })

public class InterpretationDaoITest {
	@Autowired
	private InterpretationDao interpretationDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FilmDao filmDao;
		
	@Test
	public void testAddInterpretationOK(){
		int aux = interpretationDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(2);
		interpretationDao.addInterpretation(new Interpretation(person, film));
		assertEquals(aux+1, interpretationDao.findAll().size());
	}
	
	@Test
	public void testRemoveInterpretationOk(){
		int aux = interpretationDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(1);
		System.out.println(interpretationDao.removeInterpretation(new Interpretation(person, film)));
		assertEquals(aux-1, interpretationDao.findAll().size());
	}
	
	@Test
	public void testFindById() {
		Interpretation interpretation = interpretationDao.findById(2);
		assertEquals(2, interpretation.getActor().getId());
		
	}
}
