package business.controllers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.daos.DaosService;
import data.daos.PersonDao;
import data.entities.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
public class ActorControllerTest {

    @Autowired
    private DaosService daosService;

    @Autowired
    private ActorController actorController;

    @Autowired
    private PersonDao personDao;

    
    @Test
    public void testShowActor() {
    	List<Person> actorList = personDao.findActors();
    	assertTrue(actorList.size() == actorController.showActors().size());
    }
}
