package business.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.wrapper.InterpretationWrapper;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.FilmDao;
import data.daos.InterpretationDao;
import data.daos.PersonDao;
import data.entities.Film;
import data.entities.Interpretation;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class InterpretationControllerTest {
	
	@Autowired
	InterpretationController interpretationController;
	
	@Autowired
	InterpretationDao interpretationDao;
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	FilmDao filmDao;
	
	@Test
	public void getInterpretationTest(){
		InterpretationWrapper interpretation = interpretationController.getInterpretation(1);
		assertEquals(interpretationDao.findById(1).getActor(), interpretation.getActor());
		assertEquals(interpretationDao.findById(1).getFilm(), interpretation.getFilm());
	}
	@Test
	public void createInterpretationTest(){
		int numInterpretations = interpretationDao.findAll().size();
		Person person = personDao.findById(1);
		Film film = filmDao.findById(2);
		interpretationController.createInterpretation(new InterpretationWrapper(new Interpretation(person,film)));
		assertEquals(numInterpretations+1, interpretationDao.findAll().size());
	}
	
	@Test
	public void showInterpretationsTest(){
		int numInterpretations = interpretationDao.findAll().size();
		assertEquals(numInterpretations, interpretationController.showInterpretations().size());
	}

	@Test
	public void deleteInterpretationTest(){
		int aux = interpretationDao.findAll().size();
		interpretationController.deleteInterpretation(1);
		assertEquals(aux-1, interpretationDao.findAll().size());
	}
	
	@Test
	public void updateInterpretationTest(){
		Interpretation interpretation = interpretationDao.findById(2);
		interpretation.setFilm(filmDao.findById(2));
		InterpretationWrapper interpretationWrapper = new InterpretationWrapper(interpretation);
		interpretationController.updateInterpretation(2, interpretationWrapper);
		assertTrue(interpretationDao.findById(2).getFilm().getId() == 2);
	}
}
