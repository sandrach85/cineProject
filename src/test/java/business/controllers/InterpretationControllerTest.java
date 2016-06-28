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
import data.daos.InterpretationDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})

public class InterpretationControllerTest {
	
	@Autowired
	InterpretationController interpretationController;
	
	@Autowired
	InterpretationDao interpretationDao;
	
	@Test
	public void getInterpretationTest(){
		InterpretationWrapper interpretation = interpretationController.getInterpretation(1);
		assertEquals(interpretationDao.findById(1).getActor(), interpretation.getActor());
		assertEquals(interpretationDao.findById(1).getFilm(), interpretation.getFilm());
		
	}

}
