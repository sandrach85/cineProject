package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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


public class DirectionResourceTest {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private DirectionDao directionDao;
	
	@Test
	public void getDirectionTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.DIRECTORS).path("/1").build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		DirectionWrapper response = new RestTemplate().exchange(requestEntity, DirectionWrapper.class).getBody();
		assertTrue(response.getDirector().getId()==1);
	}
	
	@Test
	public void getDirectionsTest(){
		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.DIRECTORS).build().encode().toUri();
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
		List<DirectionWrapper> response = Arrays.asList(new RestTemplate().exchange(requestEntity, DirectionWrapper[].class).getBody());
		assertEquals(response.size(), directionDao.findAll().size());
	}
	
	@Test
	public void deleteDirectionTest(){
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.DIRECTORS).pathId(1).delete().build();
		assertNull(directionDao.findById(1));
	}
	
	@Test
	public void createDirectionTest(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(2);
		DirectionWrapper direction = new DirectionWrapper(new Direction(p1,f1));
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.DIRECTORS).body(direction).post().build();
		assertEquals(directionDao.findAll().size(), 2);
	}
	
	@Test
	public void updateDirectionTest(){
		Person p1 = personDao.findById(1);
		Film f1 = filmDao.findById(2);
		DirectionWrapper direction = new DirectionWrapper(new Direction(p1,f1));
		direction.setId(2);
		new RestBuilder<Object>("http://localhost:8080/Cine.Spring.0.0.1-SNAPSHOT").path(Uris.DIRECTORS).body(direction).put().build();
		assertTrue(directionDao.findById(2).getDirector().getId()==2);
	}

}
