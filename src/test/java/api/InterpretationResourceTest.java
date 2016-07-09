package api;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import business.api.Uris;
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

public class InterpretationResourceTest {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private InterpretationDao interpretationDao;
	
	@Test
	public void getInterpretationTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.ACTORS).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		InterpretationWrapper response = new RestTemplate().exchange(requestEntity, InterpretationWrapper.class).getBody();
		assertTrue(response.getActor().getId()==1);
	}
	
	@Test
	public void getInterpretationsTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.ACTORS).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<InterpretationWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, InterpretationWrapper[].class).getBody());
		assertEquals(response.size(), interpretationDao.findAll().size());
	}
	
	@Test
	public void deleteInterpretationTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.ACTORS).pathId(1).delete().build();
		assertNull(interpretationDao.findById(1));
	}
	
	@Test
	public void createInterpretationTest(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(2);
		InterpretationWrapper interpretation = new InterpretationWrapper(new Interpretation(p1,f1));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.ACTORS).body(interpretation).post().build();
		assertEquals(interpretationDao.findAll().size(), 3);
	}
	
	@Test
	public void updateInterpretationTest(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(2);
		InterpretationWrapper interpretation = new InterpretationWrapper(new Interpretation(p1,f1));
		interpretation.setId(2);
		//new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.ACTORS).body(interpretation).put().build();
		//assertTrue(interpretationDao.findById(2).getActor().getId()==2);
	}

}
